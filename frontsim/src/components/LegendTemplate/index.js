import React from 'react'
import {
    Align,
    Template
} from './styles.js';

export default function LegendTemplate() {

    return (
        <Align>
            <Template type="red" text="Incompleto"/>
            <Template type="green" text="Completado"/>
            <Template text="Inativo"/>
        </Align>
    )
}