import styled from 'styled-components';

import { colors, metrics } from '~/styles';
import { Link } from 'react-router-dom'

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'

export const AlignV = styled(AlignVertically)`
    justify-content:start;
    align-items:${props => props.center ? 'center' : 'flex-start'};
    /* border:1px solid; */

`;
export const DrawLine = styled.div`
    width:80px;
    height:5px;
    background-color:${colors.primary};
    opacity:0.5;
`;

export const Align = styled.div`
    flex-direction:row;
    justify-content:space-around;
`;

export const LinkTo = styled(Link)`
    cursor:pointer;
    &:hover, &:visited, &:link, &:active {
        text-decoration: none;
    }
`;

export const Card = styled(ContainerWhite)`
    height:85px;
    width:75px;
    margin:20px 20px;
    padding-top:20px;
    text-align:center;
    font-weight: 300;
    font-style: normal;
    font-size:12px;
    background-color:${props => props.add ? colors.primary : colors.primaryWhite};
    color: ${props => props.add ? colors.primaryWhite : colors.gray};

`;

export const TextCard = styled.h5`
    font-weight: 700;
    font-style: normal;
    font-size:12px;
    cursor:pointer;
    padding-left:${props => props.dots ? 0 : 5 }px;
`;

export const Suport = styled.div`
    display:${props => props.display ? "inline" : "none"};
    /* height:40px; */
    width:88px;
    border:1px solid rgba(61,57,63,0.2);
    padding-top:6px;
    border-radius:4px;
`;

export const Divider = styled.div`
    height:1px;
    width:87px;
    background-color:${colors.gray};
    opacity:0.2;
    margin-bottom:6px;
`;
