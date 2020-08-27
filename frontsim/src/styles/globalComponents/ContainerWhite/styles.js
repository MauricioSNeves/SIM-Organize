import styled from 'styled-components';

import { colors } from '~/styles';

export const ContainerWhite = styled.div`
    width:370px;
    height:500px;
    background-color:${colors.primaryWhite};
    border-radius: 2px;
    -webkit-box-shadow: 0px 1px 5px 1px rgba(0,0,0,0.75);
    -moz-box-shadow: 0px 1px 5px 1px rgba(0,0,0,0.75);
    box-shadow: 0px 1px 5px 1px rgba(0,0,0,0.75);
    margin-bottom:20px;
`;
