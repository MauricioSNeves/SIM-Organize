import styled from 'styled-components';

import { colors } from '~/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'


const defineTypeLegend = (value) => {
    switch (value) {
        case "green":
            return colors.green;
        case "red":
            return colors.red;
        default:
            return colors.lightGray;
    }
}

export const Align = styled(AlignVertically)``;

export const LegendLine = styled(AlignHorizontally)`
`;

export const Options = styled.option`
`;

export const Form = styled.div`
    width:18px;
    height:18px;
    float:left   ;
    margin:4px;  
    border-radius:4px;
    background:${ ({ type }) => defineTypeLegend(type)}
`;
