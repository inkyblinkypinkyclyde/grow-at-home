import React from "react";
import styled from "styled-components"

const ClickableDiv = styled.div`
background-color: aquamarine;
`
const PlantDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`
const OptionsDiv = styled.div`
display: grid;
grid-template-columns: 50% 50%;
`
const ShowWaterDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
background-color: aliceblue;
text-align: center;
`
const ShowHarvestDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
background-color: brown;
text-align: center;
`
const Plant = ({ plant, onWaterClick, onHarvestClick }) => {
    const handleWaterClick = () => {
        onWaterClick(plant)
    }
    const handleHarvestClick = () => {
        onHarvestClick(plant)
    }

    const getLastThreeDaysOfWaterings = () => {
        let wateringsForAverage = []
        const todayUnixTime = Math.floor(new Date('2022-08-26').getTime() / 1000)
        plant.waterEvents.map((waterEvent) => {
            if (Math.floor(new Date(waterEvent.eventDateTime).getTime() / 1000) > todayUnixTime - 259200) {
                wateringsForAverage.push(waterEvent)
            }
        })
        return wateringsForAverage
    }

    const averageNumberOfWaterings = () => {
        let runningTotal = 0
        getLastThreeDaysOfWaterings().forEach((watering) => {
            console.log(watering)
            runningTotal += 1
        })
        return runningTotal / 3
    }


    return (
        <ClickableDiv>
            <PlantDiv>
                <h3>{plant.name}</h3>
                <p><i>{plant.species}</i></p>
                <p>Planted on: {plant.dateAdded}</p>
                <p>Average water use: {averageNumberOfWaterings()}</p>
                <OptionsDiv>
                    <ShowWaterDiv onClick={handleWaterClick}>
                        <p>{plant.waterEvents.length} waterings</p>
                    </ShowWaterDiv>
                    <ShowHarvestDiv onClick={handleHarvestClick}>
                        <p>{plant.harvests.length} harvests</p>
                    </ShowHarvestDiv>
                </OptionsDiv>
            </PlantDiv>
        </ClickableDiv>
    )
}

export default Plant