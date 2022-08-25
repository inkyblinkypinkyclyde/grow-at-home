import React from "react";
import styled from "styled-components"
import { useState } from "react";

const ClickableDiv = styled.div`
background-color: aquamarine;
`

const BedDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const NewBed = ({ onBedSubmit, currentGarden }) => {
    const [name, setName] = useState('')
    const [reservoirCapacity, setReservoirCapacity] = useState('')

    const handleReservoirCapacityChange = (event) => {
        setReservoirCapacity(event.target.value)
    }

    const handleNameChange = (event) => {
        setName(event.target.value)
    }
    const resetForm = () => {
        setName('')
        setReservoirCapacity(0)
    }

    const handleFormSubmit = (event) => {
        const garden = currentGarden
        event.preventDefault()
        const payload = {
            name,
            reservoirCapacity,
            garden
        }
        onBedSubmit(payload)
        resetForm()
    }

    return (
        <ClickableDiv>
            <BedDiv>
                <form onSubmit={handleFormSubmit}>
                    <input type="text" name="name" value={name} onChange={handleNameChange} placeholder="New Bed" />
                    <input type="number" name="reservoirCapacity" value={reservoirCapacity} onChange={handleReservoirCapacityChange} />
                    <input type="submit" value="Add" />
                </form>
            </BedDiv>
        </ClickableDiv>
    )
}

export default NewBed