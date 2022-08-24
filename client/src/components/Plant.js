import React from "react";
import PlantWateringEvent from "./PlantWateringEvent";
import WaterEvent from "./WaterEvent";

const Plant = ({ plant }) => {
    const allPlantWateringEvents = plant.waterEvents.map((waterEvent) => {
        return (
            <div>
                <WaterEvent
                    key={waterEvent.id}
                    waterEvent={waterEvent}
                />
            </div>
        )
    })

    const noPlantWateringEvents = () => {
        return (
            <div>
                <h5>Nothing to see here</h5>
            </div>
        )
    }
    return (
        <div>
            <h4>I'm a plant and my name is: {plant.name}</h4>
            {plant.waterEvents ? allPlantWateringEvents : noPlantWateringEvents}
        </div>
    )
}

export default Plant