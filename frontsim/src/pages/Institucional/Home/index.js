import React from 'react'
import { 
    Img,
    Body,
    Back,
    Title,
    Image,
    Suport,
    BallsUp,
    AlignH,
    AlignV,
    PageTitle,
    PhraseTemplate
} from './styles.js'

import TableTemplate from '~/components/TableTemplate'
import FooterAutorais from '~/components/FooterAutorais'
import HeaderInstitucional from '~/components/HeaderInstitucional'
import simCor from '~/assets/simCor.png';
import ballsMiddle from '~/assets/ballsMiddle.svg';




export default function Home() {
    return (
        <>
            <HeaderInstitucional />
            <AlignH>
                    <Img src={simCor} />
                <PhraseTemplate>
                    A forma mais rápida, fácil e divertida de se organizar.
                </PhraseTemplate>
                <BallsUp top={340} />
                <Image src={ballsMiddle} />

            </AlignH>
            <Body>
    
                <PageTitle>SIM</PageTitle>
                <Suport>                
                    <strong>SIM (SELF IMPROVE MANAGMNET)</strong> um projeto com a metodologia do 
                    <strong> ORGANIZE</strong> que te auxilia a saber fazer sua própria gestão
                    Porque <strong>SIM</strong> você pode ser organizado, <strong>SIM</strong>
                    você pode pensar em organização e <strong>SIM</strong> você consegue ser organizado.
                </Suport>
                <TableTemplate />
            </Body>
            
            <Back>
                <AlignV>
                    <Title>Contatos</Title>
                    <Suport>
                        <b>Email:</b> Organizekey@gmail.com
                            <br/>    
                        <b>Ligue para:</b> (001) 1212-3131
                    </Suport>
                </AlignV>
            </Back>
            <FooterAutorais />

        </>
)
}
