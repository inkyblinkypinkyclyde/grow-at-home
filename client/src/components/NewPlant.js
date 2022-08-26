import React from "react";
import styled from "styled-components"
import { useState } from "react";

const ClickableDiv = styled.div`
background-color: aquamarine;
`

const PlantDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const NewPlant = ({ onPlantSubmit, currentGarden, currentBed }) => {
    const [name, setName] = useState('')
    const [species, setSpecies] = useState('')
    const [produces, setProduces] = useState('')
    const [dateAdded, setDateAdded] = useState(new Date())

    const handleNameChange = (event) => {
        setName(event.target.value)
    }
    const handleSpeciesChange = (event) => {
        setSpecies(event.target.value)
    }
    const handleProducesChange = (event) => {
        setProduces(event.target.value)
    }
    const handleDateAddedChange = (event) => {
        setDateAdded(event.target.value)
    }
    const resetForm = () => {
        setName('')
        setSpecies('')
        setProduces('')
        setDateAdded('')
    }

    const handleFormSubmit = (event) => {
        const bed = currentBed
        const garden = currentGarden
        const units = "INTEGERS"
        event.preventDefault()
        const payload = {
            name,
            garden,
            bed,
            produces,
            units,
            dateAdded
        }
        onPlantSubmit(payload)
        resetForm()
    }

    return (
        <ClickableDiv>
            <PlantDiv>
                <form onSubmit={handleFormSubmit}>
                    <input type="text" name="name" value={name} onChange={handleNameChange} placeholder="Name" />
                    <input type="text" name="species" value={species} onChange={handleSpeciesChange} placeholder="Species" />
                    <input type="text" name="produces" value={produces} onChange={handleProducesChange} placeholder="Produces" />
                    <input type="date" name="dateAdded" value={dateAdded} onChange={handleDateAddedChange} />
                    <input type="submit" />
                </form>
            </PlantDiv>
        </ClickableDiv>
    )
}

export default NewPlant