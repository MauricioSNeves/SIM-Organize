import React from 'react'
import { Link } from 'react-router-dom';
import {
    Logo,
    Align,
    AlignH,
    HeaderInstitucionalCpt
} from './styles'


import organizeCerto from '~/assets/organizeCerto.jpg'

export default function HeaderInstitucional() {
    
    return (
        <HeaderInstitucionalCpt>  
            <Link to={"/"} style={{ textDecoration: "none" }}>
                <Logo src={organizeCerto} />
            </Link>
            <AlignH>
            <Link to={"/"} style={{ textDecoration: "none" }}>
                <Align>  Home </Align>
            </Link>
            <Link to={"/startup"} style={{ textDecoration: "none" }}>
                <Align>  Startup </Align>
                </Link>
            </AlignH>
            <AlignH>
            <Link to={"/login"} style={{ textDecoration: "none" }}>
                <Align>  Login </Align>
            </Link>
            <Link to={"/register"} style={{ textDecoration: "none" }}>
                <Align>  Cadastro </Align>
                </Link>
            </AlignH>
        </HeaderInstitucionalCpt>

    )
}   