import React from 'react'

import {
    Img,
    Title,
    Icon,
    Suport,
    AlignV,
    AlignH,
    PageTitle
} from './styles.js'

import startup from '~/assets/startup.png'
import lux from '~/assets/lux.png'
import oportunidade from '~/assets/oportunidade.png'
import alvo from '~/assets/alvo.svg'
import valor from '~/assets/valor.svg'

import FooterAutorais from '~/components/FooterAutorais'
import HeaderInstitucional from '~/components/HeaderInstitucional'


export default function Startup() {
    return (
        <>
            <HeaderInstitucional/>
            <AlignH>
                <Img src={startup}/>
                <AlignV>
                    <PageTitle>Startup</PageTitle>

                    <Suport padding>
                        Iniciada em 2018, por um grupo de pessoas de 
                        areas de trabalho diferentes, mas com o mesmo propósito, organização.
                        Em pouco tempo tranformou-se em uma Startup bem reconhecida no mercado
                        com seu Produto SIM. 
                        <br /><br />
                        A forma como atua no mercado e sua produtividade vem de uma de suas caracteristicas principais:  o reconheciento
                        de seus colaboradores e incetivo a criatividade e harmonia entre vida profissional e pessoal.
                        <br /><br />
                        Buscamos trazer com criativadade um otimo ambiente para nossos clientes. Investimos pesado nos nossos funcionários,
                         gerenciamento técnico e socioemocional. Somos mais que uma Startup somos uma Família.
                    </Suport>
                </AlignV>
            </AlignH>

            <Img src={lux} width={90} height={200}/>
                <Suport>
                    Buscamos trazer com criativadade um otimo ambiente para nossos clientes. 
                    Investimos pesado nos nossos funcionários, 
                    gerenciamento técnico e socioemocional. Somos mais que uma Startup somos uma Família.
                </Suport>

                <AlignH>
                    <AlignV>
                        <Icon src={alvo} />
                        <Title>Missão</Title>

                        Proporcionar a melhor, e, <br />
                        mais divertida experiênca de  <br />
                        auto-gerenciamento.

                    </AlignV>
                    <AlignV>
                        <Icon src={oportunidade} />
                        <Title>Visão</Title>

                        Aprimorar cada vez mais, e, <br />
                        trazendo uma experiência  <br />
                        fluída e melhor.

                    </AlignV>
                    <AlignV>
                        <Icon src={valor} />
                        <Title>Valores</Title>

                        - Transparência<br />
                        - Confiança<br/>
                        - Cresciemnto Pessoal e Geral

                    </AlignV>
            </AlignH>
            <FooterAutorais/>
        </>
    )
}
