import React from "react";
import { Link } from "react-router-dom"
import styled from "styled-components";

const MenuList = styled.ul`
list-style: none;
`

const MenuLink = styled(Link)`
text-decoration: none;
color: black;
cursor: pointer;
&:hover {
    color: #D42B88;
}
`

const MenuHeader = styled.div`
padding: 1rem;
background-color: #2BD477;

`

const NavBar = () => {
    return (
        <MenuHeader>
            <h1>Home</h1>
            <MenuList>
                <li>
                    <MenuLink to="/">Homepage</MenuLink>
                </li>
                <li>
                    <MenuLink to="/garden">My Gardens</MenuLink>
                </li>
            </MenuList>
        </MenuHeader>

    )
}

export default NavBar
