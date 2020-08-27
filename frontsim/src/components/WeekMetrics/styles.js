import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'



export const Title = styled(PageTitleTemplate)`
    font-size:${ props => (props.mci ? metrics.fontSize.big : metrics.fontSize.extraMedium)}px;
    color:${colors.primaryWhite};
`;

export const Description = styled.p`
    align-items:baseline;
    margin-bottom:10px;
`;

export const TextAreaCpt = styled.textarea`
    height: 150px;
    width: 344px;
    opacity: 0.8;
    color: ${colors.gray};
    border: 1px solid rgba(61, 57, 63, 0.1);
    border-radius: 4px;
    box-sizing: border-box;
    padding: 4px;
    background: #F5F5F5;
    margin-bottom:20px;
`;

export const Suport = styled.div`
    display:${props => props.canSee};
`;

export const Box = styled(AlignVertically)``;