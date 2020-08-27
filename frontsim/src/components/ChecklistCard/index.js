import React,{useState} from 'react'
import { FiTrash2, FiEdit3 } from "react-icons/fi";

import {
    Text,
    Align,
    ConfigIcon,
    AlignItems,
    Description
} from './styles'
import CheckboxCpt from '../Checkbox'


export default function CheckListCard({ 
    edit,
    delet,
    vai,
    title,
    conclude,
    checkValue,
    description,
    ...props })
{
    // onClick, onChange,
    const [checked, isChecked] = useState(false);
    const [visible, isVisible] = useState(false);

    function verifying() {
        vai()
        !checked ? isChecked(false) : isChecked(true);
    }
    return (
        <Align {...props} >

            <AlignItems active={true}>
                <CheckboxCpt onChange={verifying} onClick={verifying} checked={checked} />
                
                <Text onClick={() => visible ? isVisible(false) : isVisible(true)}>
                    {title}
                    <Description isVisible={visible}>{description}</Description>
                </Text>
            </AlignItems>

            <AlignItems>
                <ConfigIcon onClick={edit}>
                    <FiEdit3 size={20} />
                </ConfigIcon>
                <ConfigIcon onClick={delet}>
                    <FiTrash2 size={20} />
                </ConfigIcon>
            </AlignItems>

        </Align>
    )
}