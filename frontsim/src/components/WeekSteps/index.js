import React from 'react'

import {
    Box,
    Ball,
    AlignV,
} from './styles'

export default function WeekSteps({
    value,
    onClickA,
    onClickB,
    taskSituationA,
    taskSituationB
})
{    
    return (
        <Box>
            <AlignV>
            <Ball onClick={onClickA}
                value={taskSituationA}>{value}
            </Ball>
            </AlignV>
            <AlignV onClick={onClickB}>
                <Ball value={taskSituationB}>{value}</Ball>
            </AlignV>
        </Box>
    )
}