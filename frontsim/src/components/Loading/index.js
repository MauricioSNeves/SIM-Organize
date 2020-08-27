import React from 'react'

import { Img } from './styles.js'
import loading from '~/assets/ballsGif.svg'

export default function Loading() {
    return (
        <Img src={loading} />
    )
}