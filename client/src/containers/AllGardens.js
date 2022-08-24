import React, { useEffect, useState } from "react"
import Garden from "../components/Garden"
import styled from "styled-components"
import Bed from "../components/Bed"
import Plant from "../components/Plant"
import WaterEvent from "../components/WaterEvent"
import NewGarden from "../components/NewGarden"

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

    useEffect(() => {
        fetchGardens()
    }, [])

    const fetchGardens = () => {
        fetch('http://localhost:8080/gardens')
            .then(response => response.json())
            .then(gardens => setGardens(gardens));
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

    const onPlantClick = (plant) => {
        setCurrentPlant(plant)
    }

    const myGardens = gardens.map((garden) => {
        return (
            <div key={garden.id}>
                <Garden onGardenClick={onGardenClick} garden={garden} key={garden.id} />
            </div>
        )
    })
    const myBeds = () => {
        if (currentGarden) {
            return currentGarden.beds.map((bed) => {
                return (
                    <div key={bed.id}>
                        <Bed bed={bed} key={bed.id} onBedClick={onBedClick} />
                    </div>
                )
            })
        }
    }
    const myPlants = () => {
        if (currentGarden && currentBed) {
            return currentBed.plants.map((plant) => {
                return (
                    <div key={plant.id}>
                        <Plant plant={plant} onPlantClick={onPlantClick} />
                    </div>
                )
            })
        }
    }

    const myWaterEvents = () => {
        if (currentGarden && currentBed && currentPlant) {
            return currentPlant.waterEvents.map((waterEvent) => {
                return (
                    <div key={waterEvent.id} >
                        <WaterEvent waterEvent={waterEvent} />
                    </div>
                )
            })
        }
    }

    return (
        <div>
            <h1>All My Gardens</h1>
            <ScrollContainer>
                <ColumnDiv>
                    {myGardens}
                    <NewGarden />
                </ColumnDiv>
                <ColumnDiv>
                    {myBeds()}
                </ColumnDiv>
                <ColumnDiv>
                    {myPlants()}
                </ColumnDiv>
                <ColumnDiv>
                    {myWaterEvents()}
                </ColumnDiv>
            </ScrollContainer>
        </div>
    )
}

export default AllGardens