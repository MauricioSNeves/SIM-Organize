import React, { useEffect, useRef } from 'react';
import { useField } from '@unform/core';

import {
    Link,
    Align,
    InputCpt,
} from './styles.js';
import Label from '../Label';

export default function InputTemplate({maxLength,name,onChange, messageError, labelName, ...rest }) {
    const inputRef = useRef(null);
    const { fieldName, registerField, error, clearError } = useField(name);

    useEffect(() => {
        registerField({
            name: fieldName,
            ref: inputRef.current,
            path:'value'
        })
    }, [fieldName, registerField])

    return (
        <Align>
            <Label labelName={labelName} />
            {error && <span style={{ color: "#f00", fontSize: 12 }}>{error}</span> ||  
                <Link>{messageError}</Link>
            }
            <InputCpt
                onFocus={clearError}
                ref={inputRef}
                onChange={onChange}
                {...rest}
                maxLength={maxLength}
            />
        </Align>
    )
}   