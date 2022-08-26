import React from "react";
import styled from "styled-components"
import { useState } from "react";

const ClickableDiv = styled.div`
background-color: aquamarine;
`
const NewHarvestEventDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`
const NewHarvestEvent = ({ onHarvestSubmit, currentPlant, currentGarden, currentBed }) => {
    const [quantity, setQuantity] = useState(0)

    const today = () => {
        let now = new Date()
        return now.toISOString().split('T')[0]
    }

    const handleQuantityChange = (event) => {
        setQuantity(event.target.value)
    }
    const resetForm = () => {
        setQuantity(0)
    }
    const handleFormSubmit = (event) => {
        // console.log('submit')
        event.preventDefault()
        const dateHarvested = today()
        const bed = currentBed
        const garden = currentGarden
        const plant = currentPlant
        const payload = {
            bed,
            garden,
            quantity,
            plant,
            dateHarvested
        }
        console.log(payload)
        onHarvestSubmit(payload)
        resetForm()
    }
    return (
        <ClickableDiv>
            <NewHarvestEventDiv>
                <form onSubmit={handleFormSubmit}>
                    <input type="number" value={quantity} onChange={handleQuantityChange} />
                </form>
            </NewHarvestEventDiv>
        </ClickableDiv>
    )
}

export default NewHarvestEvent