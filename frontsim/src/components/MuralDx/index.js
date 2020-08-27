import React, {useState} from 'react'

import {
    Card,
    Divider,
    LinkTo,
    TextCard,
    AlignV,
    Suport 
} from './styles'

export default function MuralDx({
    onClick,
    linkTo,
    name,
    deletarDx,
    exportarDx
})
{    
    const [ boxOpen, setBoxOpen] = useState(false)
    return (
        <>
            <AlignV center onClick={onClick}>
                <LinkTo to={linkTo}>
                    <Card add >{name}</Card>
                </LinkTo>
                <TextCard dots onClick={()=> boxOpen ? setBoxOpen(false) : setBoxOpen(true)}> ... </TextCard>
                <Suport display={boxOpen}>
                    <TextCard onClick={deletarDx}> Deletar 4DX </TextCard>
                    <Divider/>
                    <TextCard onClick={exportarDx}> Exportar 4Dx </TextCard>
                </Suport>
            </AlignV>

            
        </>
    )
}