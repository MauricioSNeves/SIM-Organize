import styled from 'styled-components';

import { colors, metrics } from '~/styles';
import { Link } from 'react-router-dom'

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'

export const AlignV = styled(AlignVertically)`
    justify-content:start;
    align-items:${props => props.center ?'center' :'flex-start'};
    /* border:1px solid; */

`;

export const AlignH = styled(AlignHorizontally)`
    width:100%;
    justify-content:${props => props.space ? "initial" : "space-evenly"};
    max-width:${props => props.width ? 600 : "unset"}px;
    margin:30px 0px;
    /* border:1px solid; */
`;

export const PageTitle = styled(PageTitleTemplate)`
`;

export const Suport = styled.div`
    display:${props => props.display ? "inline" : "none"};

`;


export const Body = styled.div`
    margin-left:75px;
    padding:2px;
`;

export const Img = styled.img`
    margin-top:20px;
    height:300px;
    height:300px;
`;

export const SuplementarText = styled.h2`
    /* margin-top:60px; */
    margin-bottom:20px;
    color: ${colors.gray};
    font-weight: 300;
    font-style: normal;
    font-size:${metrics.fontSize.big}px;
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


export const Text = styled.p`
    font-weight: 700;
    font-style: normal;
    font-size:12px;
    margin-top:0.5em;
`;
export const TextCard = styled.p`
    font-weight: 700;
    font-style: normal;
    font-size:12px;
    /* margin-top:0.5em; */
    text-align:center;
    cursor:pointer;
`;
export const Paragraph = styled.p`
    font-weight: 600;
    font-style: normal;
    font-size:${metrics.fontSize.small}px;
    margin-top:1em;
    border-bottom:2px solid;
    &:hover{
        font-size:${metrics.fontSize.medium}px;
        color:${colors.terciary};
    }
    cursor:pointer;
`;

export const LinkTo = styled(Link)`
    cursor:pointer;
    &:hover, &:visited, &:link, &:active {
        text-decoration: none;
    }
`;