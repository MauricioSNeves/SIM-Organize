import styled from 'styled-components';


import {colors, metrics} from '~/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'


export const Align = styled(AlignVertically)`
    justify-content:center;
    text-align:center;
    width:600px;
    height:500px;
`;

export const AlignH = styled(AlignHorizontally)`
    justify-content:space-between;
`;
export const ButtonAlign = styled(AlignHorizontally)`
       justify-content:space-around;
        position:relative;
        bottom:-20px;

`;


export const Suport = styled.div`
    display:${props => props.active ? 'block' : 'none'}
`;


export const SelectCpt = styled.select`
    height: 40px;
    width: 344px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    margin-bottom:20px;
    background: #F5F5F5;
`;

export const Title = styled.p`
    font-weight: 700;
    font-style: normal;
font-size:${metrics.fontSize.extraMedium}px;
    /* margin-top:0.5em; */
`;

export const Paragraph = styled.p`
    font-weight:${props => props.weight ? 600 : 300};
    font-style: normal;
    font-size:${metrics.fontSize.small}px;
    margin-top:1em;
    margin:20px;
`;


export const Img = styled.img`
    margin-top:10px;
    height:${props => props.height ? 'unset' : 300}px;
    /* width:${props => props.width ?  80 :'unset'}px; */
`;

export const ImgF = styled.img`
    margin-top:80px;
    height:150px;
    margin-left:70px;

    /* width:${props => props.width ? 80 : 'unset'}px; */
`;

export const ImgDx = styled.img`
    /* margin-top:80px; */
    height:150px;
    /* margin-left:70px; */

    /* width:${props => props.width ? 80 : 'unset'}px; */
`;

export const Link = styled.h4`
    font-weight: 600;
    font-style: normal;
    font-size:${metrics.fontSize.small}px;
    margin-top:1em;
    margin:20px;
    color:${props => props.color ? colors.terciary : colors.black};
    &:hover{
        color:${colors.secundary};
        font-size:${metrics.fontSize.medium}px;
    }
    cursor:pointer;
`; 