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
    return (
        <ClickableDiv onClick={handleClick}>
            <GardenDiv>
                <h3>{garden.name}</h3>
                <h3>Number of beds: {garden.beds.length}</h3>
            </GardenDiv>
        </ClickableDiv>
    )
}

export default Garden