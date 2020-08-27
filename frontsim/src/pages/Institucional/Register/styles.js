import styled from 'styled-components';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { BoxBorder } from '~/styles/globalComponents/BoxBorder/styles'

export const Vertically = styled(AlignVertically)``;

export const Horizontally = styled(AlignHorizontally)`
    justify-content:${({ together }) => together ? 'center' : 'space-around'};
    margin: 10px 0px;
`;
export const Body = styled.div`
    min-height:calc(94vh - 121px);
`;


export const Suport = styled(AlignHorizontally)`
    justify-content:space-between;
`;

export const Border = styled(BoxBorder)`
    width: 445px;
    height: 460px;
`;

export const Parte1 = styled.div`
    display:${props => props.canSee};
`;
