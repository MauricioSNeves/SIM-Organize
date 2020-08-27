import React from 'react'
import { ButtonTemplate } from './styles.js'

export default function ButtonCpt({
    text,
    icon,
    type,
    value,
    onClick,
    ...props
}) {
    
    return (
        <ButtonTemplate
            {...props}
            type={type}
            value={value}
            onClick={onClick}
            
        >
          {icon}  {text}
        </ButtonTemplate>
    )
}