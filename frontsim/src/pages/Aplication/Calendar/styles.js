import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { BoxBorder } from '~/styles/globalComponents/BoxBorder/styles'

export const AlignH = styled(AlignHorizontally)`
    justify-content:space-around;
`;


export const AlignV = styled(AlignVertically)`
    justify-content:flex-start;

`;
export const Box = styled(BoxBorder)`
        padding:2px;
        position:unset;
        margin-top:30px;
        margin-bottom:50px;
`;

export const PageTitle = styled(PageTitleTemplate)`
    margin-top:100px;
`;
export const SuplementarText = styled.h2`
    /* margin-top:60px; */
    margin-bottom:20px;
    color: ${colors.gray};
    font-weight: 300;
    font-style: normal;
    font-size:${metrics.fontSize.big}px;
`;

export const Suport = styled.div`
`;
