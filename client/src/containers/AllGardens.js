import React, { useEffect, useState } from "react"
import Garden from "../components/Garden"


const AllGardens = () => {
    const [gardens, setGardens] = useState([])

    useEffect(() => {
        fetchGardens()
    }, [])

    const fetchGardens = () => {
        fetch('http://localhost:8080/gardens')
            .then(response => response.json())
            .then(gardens => setGardens(gardens));
    }

    const myGardens = gardens.map((garden) => {
        return (
            <Garden
                key={garden.id}
                garden={garden}
            />
        )
    })
    return (
        <div>
            <h1>All My Gardens</h1>
            <div>
                {myGardens}
            </div>
        </div>
    )
}

export default AllGardens