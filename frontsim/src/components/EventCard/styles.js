import styled from 'styled-components';

import { colors, metrics} from '~/styles';
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'

export const Align = styled(AlignHorizontally)`
    flex-direction:wrap;
    flex-flow:unset;
    justify-content:space-between;
    width:100%;
    min-height:50px;
    background-color:${colors.secundaryWhite} ;
    margin-bottom:1px;
    padding: 10px 10px 0px 10px;
    border: 1px solid rgba(61, 57, 63, 0.26);
`;

export const AlignItems = styled(AlignVertically)`
    padding-right:${props => props.padding}px;
    width:${props=> props.width}%;
    justify-content:flex-start;
`;  

export const ConfigIcon = styled.div`
    margin-inline-start:30px;
    cursor: pointer;
`;

export const Text  = styled.div`
    width:100%;
`;

export const Description = styled.div`
    display:${({ isVisible }) => !isVisible ? 'none' : 'block'};
    font-size:${metrics.fontSize.extraSmall}px;
    width:262px;
`;

export const Importante = styled.div`
    font-weight:600;
    font-style:normal;
    font-size:${metrics.fontSize.Small}px;   

`;

export const Spam = styled.div`
    font-weight:600;
    font-style:normal;
    font-size:${metrics.fontSize.extraSmall}px;
    opacity:0.7;
`;


export const Paragraph = styled.p`
    font-weight:300;
    font-style:normal;
    font-size:${metrics.fontSize.extraSmall}px;
`;
