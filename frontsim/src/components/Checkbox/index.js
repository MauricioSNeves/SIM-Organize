import React from 'react'

import {
    HiddenCheckbox,
    CheckboxContainer,
    StyledCheckbox
} from './styles.js'

import { FiCheck } from "react-icons/fi";
import { colors } from '~/styles';


export default function CheckboxCpt({ checked,...props }) {
    

    return (
        <CheckboxContainer {...props} >
            <HiddenCheckbox checked={checked}/>
            <StyledCheckbox checked={checked}>
                <FiCheck color={colors.primaryWhite} visibility={checked ?'visible':'hidden'}/>
            </StyledCheckbox>
        </CheckboxContainer>
    )
}