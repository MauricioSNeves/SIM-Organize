import React, { useState} from 'react'
import {
    Img,
    ImgF,
    Link,
    Title,
    Align,
    ImgDx,
    AlignH,
    Suport,
    ButtonAlign,
    Paragraph
} from './styles.js';

import grupo from '~/assets/grupo.png'
import dx from 'assets/dx.png'
import ddx from 'assets/4ddx.png'

import menina from 'assets/menina.png'

export default function Slide() {

    const [firstOpen, setFirstOpen] = useState(true);
    const [secondOpen, setSecondOpen] = useState(false);
    const [finalOpen, setFinalOpen] = useState(false);
    const [close, setClose] = useState(false);

    function one() {
        setSecondOpen(true);
        setFirstOpen(false)

    }
    function second() {
        setSecondOpen(false);
        setFinalOpen(true)
    }
    function third() {
        setFinalOpen(false);
        setClose(true)
    }

    function backOne() {
        setFirstOpen(true)
        setSecondOpen(false);
    }
    function backSecond() {
        setSecondOpen(true);
        setFinalOpen(false)
    }
    function backThird() {
        setFinalOpen(true);
        setClose(false)
    }
    return (
        <Align>
            <Suport active={firstOpen} >
            <Title>O 4DX</Title>
            <Img src={grupo}height />
            <Paragraph>
                    4Dx ou 4 Disciplinas da Execução é um método 
                    que te auxilia a<br/> 
                    alcançar metas e resultados de uma forma
                    bem diferente
            </Paragraph>
                
                <ButtonAlign>
                    <Link color onClick={one}>  
                        próximo
                    </Link>
                </ButtonAlign>
            </Suport>

            <Suport active={secondOpen} >
                <Title>Fazer com que consiga atingir objetivos</Title>
                <Img src={dx} />
                <ButtonAlign>
                    <Link onClick={backOne}>
                        voltar
                    </Link>
                    <Link color onClick={second}>
                        próximo
                    </Link>
                </ButtonAlign>
            </Suport>
            <Suport active={finalOpen} >
                <AlignH>
                    <div>
                    <Title>MCI e MDs</Title>
                {/* <Img src={dx}
                    height
                /> */}
                <Paragraph>
                    <Paragraph weight> MCI:</Paragraph>
                    Meta crucialmente importante!<br/>
                    É o seu objetivo final.
                </Paragraph>
                <Paragraph>
                    <Paragraph weight> MD's:</Paragraph>
                    Medidas de direções<br/>        
                    São as sub-tarefas mais importantes!<br />
                    Com elas você terá noção de quais tarefas <br/>escolher 
                    durante a semana.
                </Paragraph>
                    </div>
                    <div>
                    <ImgF src={menina}  />
            </div>  
            </AlignH>
                <ButtonAlign>
                    <Link onClick={backSecond}>
                        voltar
                    </Link>
                    <Link color onClick={third}>
                        próximo
                    </Link>
                </ButtonAlign>
            </Suport>

            <Suport active={close} >
                <ImgDx src={ddx}
                />
                <Title>Placar</Title>
                    <Paragraph>
                        Nele você poderá ver seu desempenho.<br />
                        Lembre-se, tem que ser simples e objetivo.
                    </Paragraph>
                    Como funciona?
                    <Paragraph>         
                    A cada semana terá que cadastrar uma nova MD até a semana final.<br />
                    A cada semana terá que dizer se finalizou ou não a tarefa da semana anterior <br /> e escolher
                    uma nova para a outra semana.
                </Paragraph>
                  
                <ButtonAlign>
                    <Link onClick={backThird}>
                        voltar
                    </Link>
                   
                </ButtonAlign>
            </Suport>

        </Align>
    )
}