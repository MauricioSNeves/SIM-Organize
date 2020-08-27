import styled from 'styled-components';

import { metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'
import SvgBallsUp from '~/components/SvgBallsUp';


export const BallsUp = styled(SvgBallsUp)`  
`;

export const Container = styled(ContainerWhite)`
    min-height: 300px;
    padding-top:30px;
    justify-content:center;
    text-align:center;
`;

export const AlignH = styled(AlignHorizontally)`
    justify-content:space-evenly;
    margin-top:50px;
`;
export const AlignV = styled(AlignVertically)`
    justify-content:space-evenly;
    margin-top:50px;
`;

export const PageTitle = styled(PageTitleTemplate)`
    margin-top:100px;
    margin-bottom:50px;
    text-align:center; 
`;
export const PhraseTemplate = styled(PageTitleTemplate)`
    width:500px;
    text-align:center;
    &:hover{
        transform:scale(1.1);
        transition-duration:1s;
    }
`;

export const Suport = styled.p`
    font-size:${metrics.fontSize.medium}px;
`;


export const Body = styled(AlignVertically)`
    padding-left:5%;
    padding-right:5%;
    align-items:center;
`;
export const Back = styled.div`
    height:200px;
    width:100%;
    background-color:RGBA(116,108,188,0.1);
    margin-top:80px;
    margin-bottom:80px;
    padding:5px;
`;


export const Img = styled.img`
    height:300px;
    width:30%;
`;

export const Image = styled.img`
    position:absolute;
    height:120px;
    width:50%;
    right:120px;
    top:370px;
`;

export const Title = styled.h4`
    font-weight:600;
`;