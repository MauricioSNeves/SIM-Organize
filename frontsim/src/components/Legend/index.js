import React from 'react'
import {
    Form,
    LegendLine
} from './styles.js';

export default function Legend({
    type,
    text,
}) {

    return (
        <LegendLine>
            <Form type={type} />
            {text}
        </LegendLine>
    )
}