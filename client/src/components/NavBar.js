import React from "react";
import { Link } from "react-router-dom"

const NavBar = () => {
    return (
        <div>
            <h1>Home</h1>
            <ul>
                <li>
                    <Link to="/">Homepage</Link>
                </li>
                <li>
                    <Link to="/garden">My Gardens</Link>
                </li>
            </ul>
        </div>

    )
}

export default NavBar
