import styled from 'styled-components';

import { colors, metrics} from '~/styles';
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'

const defineImportance = importance => {
    switch (importance) {
        case "alta":
            return colors.red;
        case "media":
            return colors.yellow;
        default:
            return colors.lightGray;
    }
}

export const Align = styled(AlignHorizontally)`
    flex-direction:wrap;
    flex-flow:unset;
    justify-content:space-between;
    align-items:center;
    width:100%;
    min-height:50px;
    background-color:${({ importance }) => defineImportance(importance) };
    margin-bottom:1px;
    padding: 10px 10px;
    &:hover{
        transform:scale(1.1)
    }
`;

export const AlignItems = styled(AlignHorizontally)`
    cursor:${({ active }) => active ? "pointer" : "default"};
`;  

export const ConfigIcon = styled.div`
    margin-inline-start:30px;
    cursor: pointer;
`;

export const Text  = styled.div`
  margin-inline-start:20px;     
`;

export const Description = styled.div`
    display:${({ isVisible }) => !isVisible ? 'none' : 'block'};
    font-size:${metrics.fontSize.extraSmall}px;
    width:180px;
`;

/* ${({ isVisible }) => isVisible ? 'none' : 'block'}; */