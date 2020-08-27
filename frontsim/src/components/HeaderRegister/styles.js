import styled from 'styled-components';

import { colors, metrics } from '~/styles';
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'

export const HeaderRegisterCpt = styled.header`
    display:flex;
    justify-content:space-between;
    flex-direction:row;
    background-color: ${colors.primary};
    min-height:55px;
    padding:10px 40px;
    -webkit-box-shadow: 6px 3px 28px -4px rgba(40,40,40,0.4); 
    box-shadow: 6px 3px 28px -4px rgba(40,40,40,0.4);
`;

export const Image = styled.img`
    width:150px;
    &:hover{
        -webkit-box-shadow: 0px 2px 21px -9px ${colors.gray};
        -moz-box-shadow: 0px 2px 21px -9px ${colors.gray};
        box-shadow: 0px 2px 21px -9px ${colors.gray};
    }
`;

export const EspecialWord = styled.b`
    color:${colors.primaryWhite};
    margin:0px;
    font-size:${metrics.fontSize.extraMedium}px;
    font-weight:700;
    font-family:'Mali';
`;

export const Text = styled.p`
    color:${colors.primaryWhite};
    margin:0px;
    padding-right:120px;
    font-weight:300;
    
`;

export const Align = styled(AlignVertically)`
    margin-top:5px;
    color:${colors.primaryWhite};
    &:hover{
        color:${colors.black};
    }
`;
