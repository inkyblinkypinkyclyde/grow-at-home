import React from "react";
import styled from "styled-components"

const ClickableDiv = styled.div`
background-color: aquamarine;
`
const HarvestDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const HarvestEvents = ({ harvest }) => {
    return (
        <ClickableDiv>
            <HarvestDiv>
                <p>Collected on: {harvest.dateHarvested}</p>
                <p>Amount: {harvest.quantity}</p>
            </HarvestDiv>
        </ClickableDiv>
    )
}

export default HarvestEvents