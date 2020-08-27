import styled from 'styled-components';

import { colors } from '~/styles';

export const CheckboxContainer = styled.div`
  display: inline-block;
  vertical-align: middle;
  text-align:center;
  
`;
// Hide checkbox visually but remain accessible to screen readers.
// Source: https://polished.js.org/docs/#hidevisually
export const HiddenCheckbox = styled.input.attrs({ type: 'checkbox' })`
  border: 0;
  clip: rect(0 0 0 0);
  height: 1px;
  margin: -1px;
  padding: 0;
  position: absolute;
  white-space: nowrap;
  width: 1px;
  border-width:20px;
`;

export const StyledCheckbox = styled.div`
  width: 25px;
  height: 25px;
  background: ${props => (props.checked ? colors.green : colors.primaryWhite)};
  border-radius: 20px;
  transition: all 150ms;
  opacity:${props => (props.checked ? 1.0 : 0.3)};
`;