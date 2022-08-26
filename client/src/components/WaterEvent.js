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