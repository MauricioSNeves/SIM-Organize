import React from 'react'

import { LabelCpt } from './styles'

export default function Label({ labelName, type }) {
    
    return (
        <LabelCpt htmlFor={type}> {labelName} </LabelCpt>

    )
}   