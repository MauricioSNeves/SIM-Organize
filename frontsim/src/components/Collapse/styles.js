import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'

function definebackgroundColor(urgency) {
    switch (urgency) {
        case 1:
            return colors.red;
        case 2:
            return colors.yellow;
        default:
            return colors.lightGray;
    }
}

export const Align = styled.div`
    align-items:baseline;
    margin-bottom:10px;
`;


export const Body = styled(AlignVertically)`
    width:${props=>props.widh}px;
    display:${props => props.display};
    overflow:auto;
    max-height:350px;
`;

export const Box = styled(AlignHorizontally)`
    justify-content:space-between;
    width:${props =>props.widhBox || 200}px;
    min-height:35px;
    padding: 8px 30px 0px 30px;
    background-color:${({ urgency }) => definebackgroundColor(urgency)};
    cursor:pointer;
`;

export const Title = styled.div`
    /* font-weight:600; */
    font-style:normal;
    font-size:${metrics.fontSize.extraSmall}px;
`;