import styled from 'styled-components';

export const Image = styled.img`
    position:absolute;
    right:${props => props.right || 0}px;
    top:${props => props.top || 'unset'}px;
`;