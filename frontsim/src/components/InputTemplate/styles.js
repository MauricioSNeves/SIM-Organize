import styled from 'styled-components';

import { colors } from '~/styles';
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { LinkPhrase } from '~/styles/globalComponents/LinkPhrase/styles'


export const InputCpt = styled.input`
    height: ${props => props.height ||40}px;
    width: ${props=> props.width || 344}px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    background: #F5F5F5;
    margin-bottom:20px;
    display:${props => props.display};
    margin-top:${props => props.top}px;

`;


export const Align = styled(AlignVertically)`
    align-items:flex-start;
`;

export const Link = styled(LinkPhrase)`
    font-size:12px;
`;





