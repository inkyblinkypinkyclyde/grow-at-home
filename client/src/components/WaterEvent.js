import React from "react";
import styled from "styled-components"

const ClickableDiv = styled.div`
background-color: aquamarine;
`
const WaterDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const WaterEvent = ({ waterEvent }) => {

    const dateWatered = Math.floor(new Date(waterEvent.eventDateTime).getTime() / 1000)
    if (dateWatered === 1661542200) {
        console.log('here')
    }
    return (
        <ClickableDiv>
            <WaterDiv>
                <p>Watered on: {waterEvent.eventDateTime}</p>
                <p>Amount: {waterEvent.duration}0ml</p>
            </WaterDiv>
        </ClickableDiv>
    )
}
export default WaterEvent