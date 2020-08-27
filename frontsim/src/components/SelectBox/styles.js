import styled from 'styled-components';


import {colors} from '~/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'

export const Align = styled(AlignVertically)`
    align-items:flex-start;
`;

export const SelectCpt = styled.select`
    height: 40px;
    width:${props => props.width || 344}px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    margin-bottom:20px;
    background: #F5F5F5;
`;

export const Options = styled.option`
`;
