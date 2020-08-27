import styled from 'styled-components';

import { colors, metrics } from '~/styles';
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles';

export const FootAutoralCpt = styled.footer`
    display:flex;
    justify-content:space-between;
    font-size:${metrics.fontSize.extraSmall}px;
    color:${colors.gray};
    opacity:0.9;
    margin-left:5px;
    align-items:flex-end;
`;

export const Image = styled.img``;


export const Suport = styled(AlignVertically)`

`;

export const Box = styled.div`
    margin-bottom:20px; 
    margin-right:460px;
`;
