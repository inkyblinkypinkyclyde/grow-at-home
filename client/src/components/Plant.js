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

    // function time_convert() {
    //     var num = plant.averageWaterInterval
    //     var hours = Math.floor(num / 60);
    //     var minutes = num % 60;
    //     return hours + ":" + minutes;
    // }


    const averageWaterInterval = () => {
        const averageseconds = Math.floor(plant.averageWaterInterval)
        console.log(averageseconds)

        const days = Math.floor(averageseconds / 86400)
        const hours = Math.floor((averageseconds - (86400 * days)) / 3600)
        const minutes = Math.floor((averageseconds - (86400 * days) - (3600 * hours)) / 60)
        const seconds = Math.floor((averageseconds - (86400 * days) - (3600 * hours) - (60 * minutes)))
        console.log(averageseconds)
        console.log(seconds)
        if (averageseconds > 0) {
            return `${days}D, ${hours}H, ${minutes}M, ${seconds}S`
        } else {
            return 'Not enough data'
        }
    }



    return (
        <ClickableDiv>
            <PlantDiv>
                <h3>{plant.name}</h3>
                <p><i>{plant.species}</i></p>
                <p>Planted on: {new Date(plant.dateAdded).toDateString()}</p>
                <p>Average watering interval: {averageWaterInterval()}</p>
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