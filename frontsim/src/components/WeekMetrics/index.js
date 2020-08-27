import React from 'react'

import {
    Box,
    Title,
    Description
} from './styles'


export default function WeekMetrics({
    title,
    description,
    ...props
}) {
    return (
        <Box>
            <Title {...props}>{title}</Title>
            <Description>{description}</Description>
        </Box>
    )
}