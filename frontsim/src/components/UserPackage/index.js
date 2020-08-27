import React from 'react'
import { FiCheckCircle } from 'react-icons/fi';
import { colors } from '~/styles';
import {
    CardTitle,
    BorderCard
} from './styles'

export default function UserPackage()
{    
    return (
        <BorderCard out>
            <CardTitle>Free</CardTitle>
            <FiCheckCircle color={colors.green}/> 4dx
            <br />
            <FiCheckCircle color={colors.green} /> Skin de 4dx
            <br />
            <FiCheckCircle color={colors.green} /> CheckList ilimitadas
        </BorderCard>
    )
}