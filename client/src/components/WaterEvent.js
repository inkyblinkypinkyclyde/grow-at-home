import React from "react";

const WaterEvent = ({ waterEvent }) => {
    return (
        <div>
            <h5>I'm a water event</h5>
            <p>Date and Time: {waterEvent.eventDateTime}</p>
            <p>Amount: {waterEvent.duration}</p>
        </div>
    )
}

export default WaterEvent