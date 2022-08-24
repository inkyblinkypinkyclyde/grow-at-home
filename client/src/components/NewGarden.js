import React from "react";
import styled from "styled-components"

const ClickableDiv = styled.div`
background-color: aquamarine;
`

const GardenDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const NewGarden = () => {
    return (
        <ClickableDiv>
            <GardenDiv>
                <p>New garden</p>
            </GardenDiv>
        </ClickableDiv>
    )
}

export default NewGarden