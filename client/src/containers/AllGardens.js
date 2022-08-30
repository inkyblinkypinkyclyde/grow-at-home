import React, { useEffect, useState } from "react"
import Garden from "../components/Garden"
import styled from "styled-components"
import Bed from "../components/Bed"
import Plant from "../components/Plant"
import WaterEvent from "../components/WaterEvent"
import NewGarden from "../components/NewGarden"
import NewBed from "../components/NewBed"
import NewPlant from "../components/NewPlant"
import HarvestEvents from "../components/HarvestEvents"
import NewHarvestEvent from "../components/NewHarvestEvent"

const ScrollContainer = styled.div`
display: grid;
grid-template-columns:  25% 25% 25% 25%;
margin: 0.25rem;
padding: 0.25rem;
`
const ColumnDiv = styled.div`
background-color: aliceblue;
margin: 0.25rem;
padding: 0.25rem;
max-height: 500px;
overflow-y: scroll;
`


const AllGardens = () => {
    const [gardens, setGardens] = useState([])
    const [currentGarden, setCurrentGarden] = useState(null)
    const [currentBed, setCurrentBed] = useState(null)
    const [currentPlant, setCurrentPlant] = useState(null)
    const [waterEventBool, setWaterEventBool] = useState(null)

    useEffect(() => {
        fetchGardens()
    }, [])

    const fetchGardens = () => {
        fetch('http://localhost:8080/gardens')
            .then(response => response.json())
            .then(gardens => setGardens(gardens));
    }



    const handleGardenSubmit = newGarden => {
        fetch('http://localhost:8080/gardens', {
            method: 'POST',
            body: JSON.stringify(newGarden),
            headers: { 'content-type': 'application/json' }
        })
            .then(() => fetchGardens())
    }
    const handleBedSubmit = newBed => {
        fetch('http://localhost:8080/beds', {
            method: 'POST',
            body: JSON.stringify(newBed),
            headers: { 'content-type': 'application/json' }
        })
            .then(() => fetchGardens())
    }
    const handlePlantSubmit = newPlant => {
        console.log(newPlant)
        fetch('http://localhost:8080/plants', {
            method: 'POST',
            body: JSON.stringify(newPlant),
            headers: { 'content-type': 'application/json' }
        })
            .then(() => fetchGardens())
    }

    const handleHarvestSubmit = (NewHarvestEvent) => {
        fetch('http://localhost:8080/harvests', {
            method: 'POST',
            body: JSON.stringify(NewHarvestEvent),
            headers: { 'content-type': 'application/json' }
        })
            .then(() => fetchGardens())
    }
    const onGardenClick = (garden) => {
        setCurrentGarden(garden)
        setCurrentBed(null)
        setCurrentPlant(null)
    }

    const onBedClick = (bed) => {
        setCurrentBed(bed)
        setCurrentPlant(null)
    }

    const onWaterClick = (plant) => {
        setCurrentPlant(plant)
        setWaterEventBool(true)
    }

    const onHarvestClick = (plant) => {
        setCurrentPlant(plant)
        setWaterEventBool(false)

    }

    const myGardens = gardens.map((garden) => {
        return (
            <div key={garden.id}>
                <Garden onGardenClick={onGardenClick} garden={garden} key={garden.id} currentGarden={currentGarden} />
            </div>
        )
    })

    const myBeds = () => {
        if (currentGarden) {
            const gardenForMap = gardens.find((garden) => garden.id === currentGarden.id)
            return gardenForMap.beds.map((bed) => {
                return (
                    <div key={bed.id}>
                        <Bed bed={bed} onBedClick={onBedClick} />
                    </div>
                )
            })
        }
    }
    const myPlants = () => {
        if (currentGarden && currentBed) {
            const gardenForMap = gardens.find((garden) => garden.id === currentGarden.id)
            const bedForMap = gardenForMap.beds.find((bed) => bed.id === currentBed.id)
            return bedForMap.plants.map((plant) => {
                return (
                    <div key={plant.id}>
                        <Plant plant={plant} onWaterClick={onWaterClick} onHarvestClick={onHarvestClick} />
                    </div>
                )
            })

        }
    }

    const myWaterEvents = () => {
        if (currentGarden && currentBed && currentPlant && waterEventBool) {
            return currentPlant.waterEvents.map((waterEvent) => {
                return (
                    <div key={waterEvent.id} >
                        <WaterEvent waterEvent={waterEvent} />
                    </div>
                )
            })
        }
    }

    const myHarvestEvents = () => {
        if (currentGarden && currentBed && currentPlant) {
            return currentPlant.harvests.map((harvest) => {
                return (
                    <div key={harvest.id} >
                        <HarvestEvents harvest={harvest} />
                    </div>
                )
            })
        }
    }

    const plantEvents = () => {
        if (currentPlant && waterEventBool) {
            return myWaterEvents()
        } else if (currentPlant && !waterEventBool) {
            return (
                <>
                    {myHarvestEvents()}
                    <NewHarvestEvent
                        onHarvestSubmit={handleHarvestSubmit}
                        currentGarden={currentGarden}
                        currentBed={currentBed}
                        currentPlant={currentPlant} />
                </>
            )
        } else {
            return null
        }

    }
    return (
        <div>

            <ScrollContainer>
                <ColumnDiv>
                    {myGardens}
                    <NewGarden onGardenSubmit={handleGardenSubmit} />
                </ColumnDiv>
                <ColumnDiv>
                    {myBeds()}
                    {currentGarden ? <NewBed onBedSubmit={handleBedSubmit} currentGarden={currentGarden} /> : null}
                </ColumnDiv>
                <ColumnDiv>
                    {myPlants()}
                    {currentBed ? <NewPlant onPlantSubmit={handlePlantSubmit} currentGarden={currentGarden} currentBed={currentBed} /> : null}
                </ColumnDiv>
                <ColumnDiv>
                    {plantEvents()}
                </ColumnDiv>
            </ScrollContainer>
        </div>
    )
}

export default AllGardens