import styled from 'styled-components';

import { colors, metrics } from '~/styles'
import Legend from '../Legend'
import { GeometricForm } from '~/styles/globalComponents/GeometricForm/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'


const defineTypeLegend = (value) => {
    switch (value) {
        case 1:
            return colors.green;
        case 2:
            return colors.red;
        default:
            return colors.lightGray;
    }
}


export const Align = styled(AlignVertically)`
    align-items:flex-start;
`;


export const Template = styled(Legend)`
`;

export const Form = styled(GeometricForm)`
    width:18px;
    height:18px;
    margin:4px;  
    border:unset;
    border-radius:4px;
    text-align:center;
    background:${ ({ type }) => defineTypeLegend(type)};
    font-size:${metrics.fontSize.littleSmall}px;
`;

export const Box = styled(AlignHorizontally)`
    justify-content:flex-start;
    margin-left:4px;  
`;