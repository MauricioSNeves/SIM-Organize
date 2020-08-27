import React,{useState} from 'react'

import {
    Text,
    Spam,
    Align,
    Importante,
    ConfigIcon,
    Paragraph,
    AlignItems,
    Description
} from './styles'


export default function EventCard({ 
    place,
    finalDate,
    name,
    onClickFinish,
    description,
    ...props })
{
    // onClick, onChange,
    const [visible, isVisible] = useState(false);

    return (
        <Align {...props} >
            <AlignItems active={true} cursor justify width={70}>                
                <Text >
                    <Importante>{description}</Importante>
                    <Spam>
                        {place}
                    </Spam>
                </Text>
            </AlignItems>

            <AlignItems padding={20}>
                <Importante top={20}> {finalDate}</Importante> 
                <Paragraph onClick={onClickFinish}>Finalizar</Paragraph>
            </AlignItems>

        </Align>
    )
}