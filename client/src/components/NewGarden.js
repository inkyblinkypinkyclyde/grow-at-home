import React from "react";
import styled from "styled-components"
import { useState } from "react";

const ClickableDiv = styled.div`
background-color: aquamarine;
`

const GardenDiv = styled.div`
margin: 0.25rem;
padding: 0.25rem;
`

const NewGarden = ({ onGardenSubmit }) => {
    const [name, setName] = useState('')



    const handleNameChange = (event) => {
        setName(event.target.value)
    }
    const resetForm = () => {
        setName('')
    }

    const handleFormSubmit = (event) => {
        event.preventDefault()
        const payload = {
            name
        }
        onGardenSubmit(payload)
        resetForm()
    }

    return (
        <ClickableDiv>
            <GardenDiv>
                <form onSubmit={handleFormSubmit}>
                    <input type="text" name="name" value={name} onChange={handleNameChange} placeholder="New Garden" />
                </form>
            </GardenDiv>
        </ClickableDiv>
    )
}

export default NewGarden