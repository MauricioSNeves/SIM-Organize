import styled, { keyframes } from 'styled-components';

import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'

const fadeIn = keyframes`
  from {
    opacity: 0.5;
  }

  to {
    opacity: 1;
  }
`;

const fadeOut = keyframes`
  from {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
`;

export const CardTitle = styled.h5`
    font-weight:700;
    text-align:center;
    margin:5px;
`;

export const BorderCard = styled(ContainerWhite)`
    position:unset;
    padding:20px 20px;    
    margin: 10px 10px 20px 10px;
    min-height:150px;
    width:230px;

    &:hover {
    animation: ${props => props.out ? fadeOut : fadeIn} 2s linear;
    transition: visibility 2s linear;
    }

`;

