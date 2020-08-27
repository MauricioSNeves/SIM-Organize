import React, { useState } from 'react'
import { FiChevronDown, FiChevronUp } from "react-icons/fi";

import {
    Box,
    Body,
    Title,
    Align,
} from './styles'

import Label from '../Label';

export default function Collpase({
    type,
    body,
    urgency,
    onChange,
    labelName,
    placeholder,
    valueTextArea,
    ...props
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
        <Align {...props}>
            <Box  {...props} onClick={showDescription} urgency={urgency} >
                <Title>{labelName}</Title>
                <FiChevronDown style={{marginTop:3}} display={visibleIcon} />
                <FiChevronUp display={visibleBox} style={{ marginTop: 3 }}/>
            </Box>
            <Body  {...props} display={visibleBox}>
                {body}
           </Body>
        </Align>
    )
}