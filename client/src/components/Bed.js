import React from "react";
import Plant from "./Plant";

const Bed = ({ bed }) => {

    const allPlants = bed.plants.map((plant) => {
        return (
            <Plant
                key={plant.id}
                plant={plant}
            />
        )
    })
    return (
        <div>
            <h3>I'm a bed and my name is: {bed.name}</h3>
            {allPlants}
        </div>
    )
}

export default Bed;