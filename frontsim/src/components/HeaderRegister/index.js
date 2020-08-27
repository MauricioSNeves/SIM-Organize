import React from 'react'
import { Link } from 'react-router-dom';
import {
    Text,
    Align,
    Image,
    EspecialWord,
    HeaderRegisterCpt
} from './styles'


import organizeCerto from '~/assets/organizeCerto.jpg'

export default function HeaderRegister() {
    
    return (
        <HeaderRegisterCpt>  
            <Link to={"/"} style={{ textDecoration: "none" }}>
                <Image src={organizeCerto} />
            </Link>
            <Text> <EspecialWord>Cadastre-se </EspecialWord>e comece a se organizar já! </Text>
            <Link to={"/login"} style={{ textDecoration: "none" }}>
                <Align>  Login </Align>
            </Link>
        </HeaderRegisterCpt>

    )
}   