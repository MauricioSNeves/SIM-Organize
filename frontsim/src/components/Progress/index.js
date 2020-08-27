import React from 'react'

import {
    DrawLine,
    DrawBall,
} from './styles'

export default function Progress({ativoOne, ativoTwo})
{    
    return (
        <>
            <DrawBall ativo={ativoOne}/>
            <DrawLine/>
            <DrawBall ativo={ativoTwo}/>
        </>
    )
}