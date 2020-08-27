import React, { useState } from 'react'
import { FiChevronDown, FiChevronUp } from "react-icons/fi";

import {
    Box,
    Align,
    TextAreaCpt
} from './styles'

import Label from '../Label';

export default function TextArea({
    type,
    onChange,
    labelName,
    placeholder,
    valueTextArea
}) {
    const [visibleBox, setVisibleBox] = useState("none")
    const [visibleIcon, setVisibleIcon] = useState("block")

    function showDescription() {
        visibleBox === "none"
            ? setVisibleBox("block") : setVisibleBox("none");
        visibleIcon === "block"
            ? setVisibleIcon("none") : setVisibleIcon("block");
    }

    return (
        <Align>
            <Box onClick={showDescription}>
                <Label labelName={labelName} type={type} />
                <FiChevronDown display={visibleIcon} />
                <FiChevronUp display={visibleBox} />
            </Box>
            <TextAreaCpt
                placeholder={placeholder}
                canSee={visibleBox}
                value={valueTextArea}
                maxLength={70}
                onChange={onChange}
            />
                
        </Align>
    )
}