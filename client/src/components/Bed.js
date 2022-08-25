import React from "react";
import styled from "styled-components"

const ClickableDiv = styled.div`
background-color: aquamarine;
`
const BedDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`
const Bed = ({ bed, onBedClick }) => {
    const handleClick = () => {
        onBedClick(bed)
    }

    return (
        <ClickableDiv onClick={handleClick}>
            <BedDiv>
                <h3>{bed.name}</h3>
                <h3>Reservoir Capacity: {bed.reservoirCapacity}</h3>
            </BedDiv>
        </ClickableDiv>
    )
}

export default Bed;