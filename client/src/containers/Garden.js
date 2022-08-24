import React, { useEffect, useState } from "react"


const Garden = () => {
    const [gardens, setGardens] = useState([])

    useEffect(() => {
        fetchGardens()
    }, [])

    const fetchGardens = () => {
        fetch('http://localhost:8080/gardens')
            .then(response => response.json())
            .then(gardens => setGardens(gardens));
    }
    return (
        <h1>I am a garden</h1>
    )
}

export default Garden