import React from 'react';

import { Image } from './styles.js';
import ballsUp from '~/assets/ballsUp.svg';

export default function svgBallsUp({...props}) {
    return(
        <Image src={ballsUp} {...props}/>
    )

}