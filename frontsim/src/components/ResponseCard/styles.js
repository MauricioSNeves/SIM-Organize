import styled from 'styled-components';


import {colors, metrics} from '~/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'


function giveTheColor(colorBack) {
    switch (colorBack) {
        case "good":
            return colors.green;
        case "bad":
            return colors.red;
        default:
            return colors.gray;
    }
}

export const Box = styled(ContainerWhite)`
    width:${props=>props.width || 205}px;
    height:${props=>props.height || 60}px;
    position:absolute;
    bottom:15px;
    right:185px;
    padding:10px 10px;
    color:${colors.primaryWhite};
    background-color:${({ colorBack }) => giveTheColor(colorBack) };
`;

export const Paragraph = styled.p`
    font-weight: 600;
    font-style: normal;
    font-size:${metrics.fontSize.small}px;
    display:${props => props.good ? "inline" : "none"};

`;

