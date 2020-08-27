import styled from 'styled-components';

import { metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import SvgBallsUp from '~/components/SvgBallsUp';


export const BallsUp = styled(SvgBallsUp)`  
`;

export const AlignH = styled(AlignHorizontally)`
    justify-content:space-around;
    align-items:center;
    margin-bottom:80px;
`;
export const AlignV = styled(AlignVertically)`
    width:30%;
`;

export const PageTitle = styled(PageTitleTemplate)`
    margin-bottom:50px;
    text-align:center; 
    &:hover{
        transform:scale(1.5)
    }
`;


export const Suport = styled.p`
    font-size:${metrics.fontSize.medium}px;
    text-align:justify;
    padding:${props => props.padding || 60}px;
`;


export const Img = styled.img`
    height:${props => props.height || 350}px;
    width:${props => props.width || 40}%;
    margin:65px;    
    
`;

export const Icon = styled.img`
    margin:20px;
    height:90px;
    width:90px;
    &:hover{
        transform:scale(1.5)
    }
`;

export const Title = styled.h4`
    font-weight:600;
    margin:10px;
`;