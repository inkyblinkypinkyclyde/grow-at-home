import React from "react"
import styled from "styled-components"


const ClickableDiv = styled.div`
background-color: aquamarine;
`

const GardenDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const Garden = ({ garden, onGardenClick, currentGarden }) => {
    const handleClick = () => {
        onGardenClick(garden)
    }
    const numberOfPlants = () => {
        let counter = 0
        garden.beds.map((bed) => {
            counter = counter + bed.plants.length
        })
        return counter
    }
    const totalHarvests = () => {
        let counter = 0
        garden.beds.map((bed) => {
            bed.plants.map((plant) => {
                counter = counter + plant.harvests.length
            })
        })
        return counter
    }

    const totalWaterUse = () => {
        let counter = 0
        garden.beds.map((bed) => {
            bed.plants.map((plant) => {
                plant.waterEvents.map((waterEvent) => {
                    counter = counter + waterEvent.duration
                })
            })
        })
        if (counter == 0) {
            return 'n/a'
        } else {
            return counter
        }
    }


    return (
        <ClickableDiv onClick={handleClick}>
            <GardenDiv>
                <h3>{garden.name}</h3>
                <table>
                    <tbody>
                        <tr>
                            <td>Beds:</td>
                            <td>{garden.beds.length}</td>
                            <td>Plants:</td>
                            <td>{numberOfPlants()}</td>
                        </tr>
                        <tr>
                            <td>Harvests:</td>
                            <td>{totalHarvests()}</td>
                            <td>Water usage:</td>
                            <td>{totalWaterUse()}</td>
                        </tr>
                    </tbody>
                </table>
            </GardenDiv>
        </ClickableDiv>
    )
}

export default Garden