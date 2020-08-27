import styled from 'styled-components'

import { colors } from '~/styles'
import {Touchable} from '~/styles/globalComponents/Touchable/styles'

export const Tr = styled.tr`
      color:${colors.black};
      /* opacity:0.9; */
`;

export const Touch = styled(Touchable)``;

export const Table = styled.table`
    width:50%;
    border-collapse:separate;
    margin-top:10%;
    margin-bottom:3%;
    ${Tr}:nth-child(even) {
        background:RGBA(116,108,188,0.1);
      }
      ${Tr}:nth-child(odd) {
        background:RGBA(116,108,188,0.33);
      }
      -webkit-border-radius: 25px;
      -moz-border-radius: 25px;

`;

export const TableHead = styled.thead`
    background-color:${colors.secundary};
    color:${colors.primaryWhite};
    font-weight:700;
`;

export const TableH = styled.th && styled.td`
   margin-left:10px;
   padding:10px 30px;
   width:${props => props.width || 'auto'};
  text-align:${props => props.align || "left"};

    
`;