import React from "react"
import Bed from "./Bed"

const Garden = ({ garden }) => {
    const allBeds = garden.beds.map((bed) => {
        return (
            <Bed
                key={bed.id}
                bed={bed}
            />
        )
    })
    return (
        <div>
            <h2>I am a garden and my name is: {garden.name}</h2>
            {allBeds}
        </div>
    )
}

export default Garden