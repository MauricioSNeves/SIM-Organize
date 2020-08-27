import React from 'react'

import {
    Box,
    Image,
    Suport,
    FootAutoralCpt
} from './styles'
import ballsDown from '~/assets/ballsDown.svg';

export default function FootAutoral() {
    
    return (
        <FootAutoralCpt>
            <Suport>
            <Box>
            Rua Eustacio Cerqueira do Vale, 1001 <br/>
            Bourdman Tous, 22º.
            </Box>
            Termos do Serviço | 
            Política de Privacidade | 
            Copyright 2020 Organize Corporation. Todos os direitos reservados.
            </Suport>
            <Image src={ballsDown} />
                
        </FootAutoralCpt>

    )
}   