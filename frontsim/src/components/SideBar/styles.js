import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { Link, NavLink, useHistory } from 'react-router-dom'

export const Align = styled.div`
    align-items:baseline;
    margin-bottom:10px;
`;

export const Body = styled.div`
    display:flex;
    position:fixed;
    top:0;
    left:0;
    height: 100%;
    width: ${props => props.open ? 150 : 75}px;
    flex-direction:column;
    justify-content:center;
    background-color:${colors.primary}; 
    -webkit-box-shadow: 6px 3px 28px -4px rgba(40,40,40,0.4); 
    box-shadow: 6px 3px 28px -4px rgba(40,40,40,0.4);

`;

export const Box = styled(AlignHorizontally)`
    justify-content:${props => props.open ? "left" : "center"};;
    margin-bottom:15px;
    margin-left:${props => props.open ? 23 : 0}px;
    cursor:pointer;
    text-align:left;
    align-items:flex-start;
`;

export const Nav = styled(NavLink)`
    padding-top:11px;
`;

export const Legend = styled.div`
    margin-left:10px;
    color:${colors.primaryWhite};
    display:${props => props.open ? "inline" : "none"};
    font-size:${metrics.fontSize.extraSmall}px;
    font-weight:300;
`;

export const Foot = styled.div`
    display:flex;
    position:absolute;
    bottom:0;
    width:100%;
    justify-content:${props => props.open ? "left" : "center"};
    margin-left:${props => props.open ? 23 : 0}px;
    margin-bottom:15px; 
    cursor:pointer;
`;

export const Icon = styled(AlignHorizontally)`
    justify-content:center;
    cursor:pointer;
    margin-bottom:100px;
    margin-top:${props => props.open ? 110 : 0}px;
`;

export const Draw = styled.div`
    width:${props => props.open ? 110 : 1}px;
    height:${props => props.open ? 1 : 110}px;
    background-color:${colors.primaryWhite};
    opacity:0.3;
    margin:1px;
`;

export const Img = styled.img`  
    display:${props => props.open ? "inline" : "none"};
    opacity:0.8;
`;

