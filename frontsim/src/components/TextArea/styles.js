import styled from 'styled-components';

import { colors } from '~/styles';

import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'


export const Align = styled.div`
    align-items:baseline;
    margin-bottom:10px;
`;

export const TextAreaCpt = styled.textarea`
    height: 100px;
    width: 344px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    background: #F5F5F5;
    margin-bottom:20px;
    display:${props => props.canSee};

`;

export const Box = styled(AlignHorizontally)`
    justify-content:space-between;
`;
