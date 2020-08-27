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
            <Text>Se <EspecialWord> organize </EspecialWord> conosco!  </Text>
            <Link to={"/register"} style={{ textDecoration: "none" }}>
                <Align>  Cadastro </Align>
            </Link>
        </HeaderRegisterCpt>

    )
}   