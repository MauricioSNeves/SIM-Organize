import React, { useState } from 'react'
import { Link, NavLink, useHistory } from 'react-router-dom'
import { FiList, FiFlag } from "react-icons/fi";
import { AiOutlineLogout } from 'react-icons/ai'
import { RiFileUserLine } from 'react-icons/ri'
import { MdDateRange } from "react-icons/md";

import { colors } from '~/styles';
import {
    Img,
    Nav,
    Box,
    Icon,
    Draw,
    Body,
    Foot,
    Legend
} from './styles'
import user from '~/assets/user.svg'

export default function SideBar() {
    const [open, setOpen] = useState(false);

    function openSideBar() {
        !open ? setOpen(true) : setOpen(false);
    }
    const history = useHistory()

    function logOut() {
        localStorage.clear();
        history.push('/')
    }
    return (
        <Body open={open}>
            {/* <Img src={user} open={open}/> */}
            <Icon onClick={openSideBar} open={open}>
                <Draw open={open} />
                <Draw open={open} />
                <Draw open={open} />
            </Icon>
            <Nav
                // activeClassName="selected"
                activeStyle={{
                    // fontWeight: "bold",
                    backgroundColor: "#48478A"
                }}
                to={"/user/checklist"} style={{ textDecoration: "none" }}>
                <Box open={open}>
                    <FiList size={20} color={colors.primaryWhite} />
                    <Legend open={open}>Checklist</Legend>
                </Box>
            </Nav>
            <Nav activeStyle={{
                // fontWeight: "bold",
                backgroundColor: "#48478A"
            }} to={"/user/initial"} style={{ textDecoration: "none" }}>
                <Box open={open}>
                    <FiFlag size={20} color={colors.primaryWhite} />
                    <Legend open={open}>Inicial 4DX</Legend>
                </Box>
            </Nav>
            <Nav activeStyle={{
                // fontWeight: "bold",
                backgroundColor: "#48478A"
            }} to={"/user/calendar"} style={{ textDecoration: "none" }}>
                <Box open={open}>
                    <MdDateRange size={20} color={colors.primaryWhite} />
                    <Legend open={open}>Calendário</Legend>
                </Box>
            </Nav>

            <Foot open={open} onClick={logOut}>
                <AiOutlineLogout size={20} color={colors.primaryWhite} />
                <Legend open={open}>Logout</Legend>
            </Foot>
        </Body>
    )
}