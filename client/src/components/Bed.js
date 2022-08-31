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

    const fillMeAlert = () => {
        if (bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 1].wet) {
            return 'OK'
        } else {
            return 'Needs water.'
        }
    }

    const averageTimeBetweenRefills = () => {
        var dataDict = {
            event1: {
                filled: null,
                emptied: null
            },
            event2: {
                filled: null,
                emptied: null
            },
            event3: {
                filled: null,
                emptied: null
            }
        }
        if (bed.waterSensorReservoirEvents.length > 5) {
            if (bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 1].wet = true) {
                dataDict.event3.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 2].eventDateTime).getTime() / 1000)
                dataDict.event3.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 3].eventDateTime).getTime() / 1000)
                dataDict.event2.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 4].eventDateTime).getTime() / 1000)
                dataDict.event2.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 5].eventDateTime).getTime() / 1000)
                dataDict.event1.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 6].eventDateTime).getTime() / 1000)
                dataDict.event1.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 7].eventDateTime).getTime() / 1000)
            } else {
                dataDict.event3.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 1].eventDateTime).getTime() / 1000)
                dataDict.event3.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 2].eventDateTime).getTime() / 1000)
                dataDict.event2.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 3].eventDateTime).getTime() / 1000)
                dataDict.event2.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 4].eventDateTime).getTime() / 1000)
                dataDict.event1.emptied = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 5].eventDateTime).getTime() / 1000)
                dataDict.event1.filled = Math.round(new Date(bed.waterSensorReservoirEvents[bed.waterSensorReservoirEvents.length - 6].eventDateTime).getTime() / 1000)
            }
            console.log(dataDict)
            const event1diff = dataDict.event1.emptied - dataDict.event1.filled
            const event2diff = dataDict.event2.emptied - dataDict.event2.filled
            const event3diff = dataDict.event3.emptied - dataDict.event3.filled
            const averageseconds = (event1diff + event2diff + event3diff) / 3
            const days = Math.floor(averageseconds / 86400)
            const hours = Math.floor((averageseconds - (86400 * days)) / 3600)
            const minutes = Math.floor((averageseconds - (86400 * days) - (3600 * hours)) / 60)
            const seconds = Math.floor((averageseconds - (86400 * days) - (3600 * hours) - (60 * minutes)) / 60)
            return `${days}D, ${hours}H, ${minutes}M, ${seconds}S`
        } else {
            return 'Not enough data yet'
        }
    }

    const smartBedData = () => {
        const dateString = bed.waterSensorReservoirEvents.findLast((event) => event.wet === true)

        return (
            <table>
                <tbody>
                    <tr>
                        <td>Reservoir Size: </td>
                        <td>{bed.reservoirCapacity}ml</td>
                    </tr>
                    <tr>
                        <td>Last filled: </td>
                        <td>
                            <p>{new Date(dateString.eventDateTime).toDateString()}</p>
                            <p>{new Date(dateString.eventDateTime).toLocaleTimeString()}</p>
                        </td>
                    </tr>
                    <tr>
                        <td>Reservoir is: </td>
                        <td>{fillMeAlert()}</td>
                    </tr>
                    <tr>
                        <td>Average: </td>
                        <td>{averageTimeBetweenRefills()}</td>
                    </tr>
                </tbody>
            </table>
        )
    }

    return (
        <ClickableDiv onClick={handleClick}>
            <BedDiv>
                <h3>{bed.name}</h3>
                {bed.reservoirCapacity ? smartBedData() : null}
            </BedDiv>
        </ClickableDiv>
    )
}

export default Bed;