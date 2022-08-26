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
    return (
        <ClickableDiv>
            <PlantDiv>
                <h3>{plant.name}</h3>
                <p><i>{plant.species}</i></p>
                <p>Planted on: {plant.dateAdded}</p>
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