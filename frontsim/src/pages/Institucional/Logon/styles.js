import styled from 'styled-components';

import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { LinkPhrase } from '~/styles/globalComponents/LinkPhrase/styles'
import { BoxBorder } from '~/styles/globalComponents/BoxBorder/styles'

export const TitleTemplate = styled(PageTitleTemplate)`
    margin-top:0px;
    margin-bottom:50px;
`;

export const Body = styled(AlignVertically)`
    min-height:calc(94vh - 111px);
    align-items:unset;
    justify-content:end;
`;


export const Vertically = styled(AlignVertically)`
`;

export const Horizontally = styled(AlignHorizontally)`
`;


export const Centralize = styled(AlignHorizontally)`
    position:absolute;
    /* bottom:8em; */
`;


export const Link = styled(LinkPhrase)``;

export const Box = styled(BoxBorder)`
`;
