import React, { useRef, useState } from 'react';
import { Form } from '@unform/web';
import * as Yup from 'yup';
import { FiCornerDownRight } from "react-icons/fi";


import {
    Box,
    Body,
    Link,
    Centralize,
    Vertically,
    Horizontally,   
    TitleTemplate
} from './styles.js';

import api from '~/services/api'


import InputTemplate from '~/components/InputTemplate'
import ButtonCpt from '~/components/Button'
import HeaderLogin from '~/components/Headerlogin'
import FooterAutorais from '~/components/FooterAutorais'
import SvgBallsUp from '~/components/SvgBallsUp';
import Loading from '~/components/Loading';
import ResponseCard from '~/components/ResponseCard'


export default function Login({ history }) {
    const [isLoading, setLoading] = useState(false);
    const [isGood, setGood] = useState(false);
    const [isBad, setBad] = useState(false);
    const [isNotConfirmed, setNotConfirmed] = useState(false);


    const formRef = useRef(null);
    
    async function handleSubmit(data, { reset }) {

        try {
            const schema = Yup.object().shape({
                email: Yup.string().email("Digite um e-mail válido").required("E-mail é obrigatório"),
                password: Yup.string().required("Digite uma senha").min(3, "A senha deve conter no minímo 3 caracteres")
            });
            await schema.validate(data, {
                abortEarly: false
            })
            formRef.current.setErrors({});

            setLoading(true);
            const email = data.email;
            const senha = data.password;

            const response = await api.post('/auth', { email, senha });
            if (response.status == 200) {
                await localStorage.setItem('token', response.data.token)
                await localStorage.setItem('tipo', response.data.tipo)
                setTimeout(() => {
                    setGood(true)
                }, 500);
                setTimeout(() => {
                    setGood(false)
                    reset();
                    setLoading(false);
                    history.push('/user/initial')
                }, 3000);
            }
            else if (response.status === 550) {
                setLoading(false);
                setTimeout(() => {
                    setNotConfirmed(true)
                }, 500);
                setTimeout(() => {
                    setNotConfirmed(false)
                }, 3000);
            }
            else {
                setLoading(false);
                    setTimeout(() => {
                        setBad(true)
                    }, 500);
                    setInterval(() => {
                        setBad(false)
                    }, 2000);
            }


        } catch (err) {
            if (err instanceof Yup.ValidationError) {
                const errorMessages = {};

                err.inner.forEach(error => {
                    errorMessages[error.path] = error.message;
                });
                formRef.current.setErrors(errorMessages);
                console.log(err);
            }
        }
    }

    return (
        <>
            <HeaderLogin />
            <SvgBallsUp />
            <Body>
                <Horizontally>
                    <Box>
                        <Vertically>
                            <TitleTemplate>Login</TitleTemplate>
                        </Vertically>
                        <Form ref={formRef} onSubmit={handleSubmit}>
                            <InputTemplate
                                type="email"
                                name="email"
                                placeholder="Email"
                                labelName="E-mail:"
                            />
                            <InputTemplate
                                name="password"
                                type="password"
                                placeholder="Senha"
                                labelName="Senha:"
                            />

                            <ButtonCpt
                                buttonId="btnCpt"
                                text="Confirmar"
                                type="submit"
                                icon={<FiCornerDownRight size={17}/>}
                            />
                        </Form>
                    </Box>
                </Horizontally>
                {isGood &&
                    <ResponseCard responseGood="  Aproveite a jornada!"
                        color="good"
                        height={42}
                        respGood={true}
                        respBad={false}
                    />}
                {isBad &&
                    <ResponseCard responseBad="  Erro de autentificação"
                        respGood={false}
                        width={220}
                        height={42}
                        respBad={true}
                />
                }            
                {isNotConfirmed &&
                    <ResponseCard responseBad="   Você ainda não confirmou seu e-mail. Estamos aguardando a confirmação."
                        width={300}
                        height={90}
                        respGood={false} respBad={true} />
                }
              
                    <Horizontally>
                    {isLoading &&  <Loading />}
                    </Horizontally>
            </Body>
            <FooterAutorais />
        </>
    )
}
