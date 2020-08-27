import React from 'react'

import { FiCheckCircle, FiX } from "react-icons/fi";
import {
    Box,
    Paragraph
} from './styles.js';
import { colors } from '~/styles'

export default function ResponseCard({respGood, respBad, responseGood, responseBad, color,...props}) {

    return (
        <Box {...props} colorBack={color}>
            <Paragraph good={respGood} >
                <FiCheckCircle  size={20} />
                {responseGood}
            </Paragraph>   
            <Paragraph good={respBad}  >
                <FiX size={20} />
                {responseBad}
            </Paragraph> 
        </Box>
    )
}