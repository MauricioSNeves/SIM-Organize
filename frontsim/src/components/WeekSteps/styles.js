import styled from 'styled-components';

import {colors} from '~/styles'
import { GeometricForm } from '~/styles/globalComponents/GeometricForm/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'


function backgroundBalls(value) {
    switch (value) {
        case "done":
            return colors.green;
        case "notDone":
            return colors.red;
        default:
            return colors.lightGray;
    }
}


export const Box = styled(AlignHorizontally)`
    width:500px;
`;

export const Ball = styled(GeometricForm)`
    width:50px;
    height:50px;
    float:left;
    border:unset;
    border-radius:50px;
    background-color:${({value}) => backgroundBalls(value)};
    color:${colors.black};
    margin-bottom:5px;
`;



export const AlignV = styled(AlignVertically)`
    justify-content:center;
`;
export const Text = styled.p`
    font-weight: 700;
    font-style: normal;
    font-size:12px;
    margin-bottom:1.5em;
    cursor:pointer;
`;