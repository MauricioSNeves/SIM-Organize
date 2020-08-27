import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'

export const SelectCpt = styled.select`
    height: 40px;
    width: 548px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    background: #F5F5F5;
`;


export const SuplementarText = styled.h2`
    margin-top:${props=>props.top ? 10:60}px;
    margin-bottom:30px;
    color: ${colors.gray};
    font-weight: 300;
    font-style: normal;
    font-size:${metrics.fontSize.big}px;
    
`;


export const AlignV = styled(AlignVertically)``;

export const AlignH = styled(AlignHorizontally)`
    flex-flow:row wrap-reverse;
    justify-content:space-evenly;
`;

export const PageTitle = styled(PageTitleTemplate)``;

export const Container = styled(ContainerWhite)`
    /* overflow:scroll;  */
    max-height:500px;
`;

export const Suport = styled.div``;

