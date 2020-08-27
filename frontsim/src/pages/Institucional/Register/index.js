import React, { useState, useRef } from 'react'
import { Form } from '@unform/web';
import * as Yup from 'yup';
import { FiCornerDownRight } from "react-icons/fi";

import InputTemplate from '~/components/InputTemplate'
import ButtonCpt from '~/components/Button'
import FooterAutorais from '~/components/FooterAutorais'
import HeaderRegister from '~/components/HeaderRegister'

import {
    Body,
    Border,
    Suport,
    Parte1,
    Horizontally
} from './styles.js'
import SvgBallsUp from '~/components/SvgBallsUp';
import Loading from '~/components/Loading';
import ResponseCard from '~/components/ResponseCard'

import api from '~/services/api.js';


export default function Register({history}) {
    const [isLoading, setLoading] = useState(false);
    const [isGood, setGood] = useState(false);
    const [isBad, setBad] = useState(false);

    const formRef = useRef(null);

    async function handleSubmit(data, event) {
        try {
            const schema = Yup.object().shape({
                email: Yup.string().email("Digite o e-mail corretamente").required("E-mail é obrigatório"),
                userName: Yup.string().required("É necessário o user name"),
                password: Yup.string().required("Senha é obrigatória").min(3, "A senha deve conter no minímo 3 caracteres")
            })
            await schema.validate(data, {
                abortEarly: false
            });
            formRef.current.setErrors({})
            
            setLoading(true);
            const email = data.email;
            const nomeUser = data.userName;
            const senha = data.password;
            const tipoAcesso = "free"

            const response = await api.post('/usuarios', { email, senha, tipoAcesso, nomeUser })
            if (response.status === 201) {
                    setLoading(false);
                    setTimeout(() => {
                        setGood(true)
                    }, 500);
                    setTimeout(() => {
                        setGood(false)
                        history.push('/login');
                    }, 3000);
            }
                else {
                    setLoading(false);
                    setTimeout(() => {
                        setBad(true)
                    }, 500);
                 setTimeout(() => {
                    setBad(false)
                        }, 3000);
                }            


        } catch (err) {
            if (err instanceof Yup.ValidationError) {
                const errorMessages = {};

                err.inner.forEach(error => {
                    errorMessages[error.path] = error.message;
                });
                formRef.current.setErrors(errorMessages);
            }
        }
    }
    return (
        <>
            <HeaderRegister />
            <Body>
                <SvgBallsUp />
                <Horizontally>
                    <Border>
                        <Horizontally together>
                        </Horizontally>
                        <Form ref={formRef} onSubmit={handleSubmit}>
                            <Parte1 >
                                <InputTemplate
                                    name="email"
                                    placeholder="Email"
                                    labelName="E-mail:"
                                    messageError="Exemplo: organize@gmail.com"
                                />
                                <InputTemplate
                                    type="text"
                                    name="userName"
                                    placeholder="User Name"
                                    labelName="User Name:"
                                    messageError="Não esqueça do user name"
                                />
                                <Suport >
                                    <InputTemplate
                                        name="password"
                                        type="password"
                                        placeholder="Senha"
                                        labelName="Senha:"
                                        messageError="Escolha uma senha forte com no minimo 3 letras"
                                    />
                                </Suport>

                                <ButtonCpt
                                    text="Efetuar cadastro"
                                    type="submit"
                                    icon={<FiCornerDownRight/>}
                                />
                                {isLoading && <Loading/>}
                            </Parte1>
                        </Form>
                    </Border>
                </Horizontally>
            </Body>
            {isGood &&
                <ResponseCard responseGood="  Cadastro efetuado com sucesso! Não esqueça de confirmar seu email"
                color="good"
                respGood={true}
                respBad={false}
                width={244}
                height={85}
            />
            }
            {isBad && 
                <ResponseCard responseBad=" Erro ao cadastrar"
                    color="bad"
                    respGood={false}
                    respBad={true}
                    height={45}
                />
            }
            <FooterAutorais />
        </>
    )
}
