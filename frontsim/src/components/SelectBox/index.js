import React from 'react'
import {
    Align,
    Options,
    SelectCpt
} from './styles.js';
import Label from '../Label';

export default function SelectBox({
    type,
    value,
    onChange,
    labelName,
    ...props
}) {

    return (
        <Align>
            <Label type={type} labelName={labelName} />
            <SelectCpt {...props}  onChange={onChange} value={value}>
                <Options value="0">--</Options>
                <Options value="baixa">Baixa</Options>
                <Options value="media">Média</Options>
                <Options value="alta">Alta</Options>
            </SelectCpt> 
        </Align>
    )
}