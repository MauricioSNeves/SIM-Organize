import styled from 'styled-components';

import { colors } from '~/styles'

export const DrawBall = styled.div`
    position:relative;
    top:-10px;
    border-radius:100%;
    width:30px;
    height:30px;
    background-color:${({ ativo }) => ativo ? colors.secundary : colors.primary};
    opacity:${({ ativo }) => ativo ? 1.0 : 0.5};
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
