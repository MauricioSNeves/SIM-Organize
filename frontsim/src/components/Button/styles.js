import styled from 'styled-components';

import { colors, metrics } from '~/styles';

export const ButtonTemplate = styled.button`
    background-color: ${({back}) => back ? colors.primaryWhite : colors.primary };
    height: ${props => props.height || 53}px;
    width:${props=> props.width || 344}px;
    font-style: normal;
    line-height: 27px;
    color: ${({ back }) => back ? colors.primary : colors.primaryWhite };
    border-radius: 4px;
    font-size:${metrics.fontSize.extraBig};
    cursor: pointer;
    margin-bottom:10px;
    border: 1px solid ${colors.primary}

`;





