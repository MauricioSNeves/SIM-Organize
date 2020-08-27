import React,{useState, useEffect, useRef} from 'react'
import { Form } from '@unform/web';
import * as Yup from 'yup';
import { IoMdAdd } from "react-icons/io";

import {
    Img,
    Text,
    Func,
    Body,
    Foot,
    Suport,
    AlignH,
    AlignHo,
    AlignV,
    Container,
    SuplementarText
} from './styles'

import LegendTemplate from '~/components/LegendTemplate';
import WeekMetrics from '~/components/WeekMetrics';
import WeekSteps from '~/components/WeekSteps';
import SideBar from '~/components/SideBar';
import Bau from '~/assets/bau.svg';
import ButtonCpt from '~/components/Button'
import InputTemplate from '~/components/InputTemplate'
import ModalCpt from '~/components/Modal'
import ResponseCard from '~/components/ResponseCard'

import api from '~/services/api'

export default function QuatroDX() {
    const [isGood, setGood] = useState(false);
    const [isBad, setBad] = useState(false);

    const [openTask, setOpenTask] = useState(false)
    const [modalIsOpenTask, setIsOpenTask] = useState(false)
    const [data, setData] = useState([])
    const [mdUm, setMdUm] = useState()
    const [mdDois, setMdDois] = useState()

    const formRef = useRef(null);
    const token = localStorage.getItem('token')

    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    const [arrayMdUm, setArrayMdUm] = useState([
        { nomeTarefaMdUm: "Cadastre sua tarefa da Md1" }
    ])
    const [arrayMdDois, setArrayMdDois] = useState([
        { nomeTarefaMdDois: "Cadastre sua tarefa da Md2" }
    ])

  

    var week = [];
    function teste(value) {
        for (var i = 1; i <= value; i++) {
            week.push(
                <WeekSteps value={i} />
            );
        }
        return week;
    }
    
    useEffect(() => {
        const id = localStorage.getItem('id');
        api.get(`metodosdxs/4dx/${id}`, config).then(response => {
            setData(response.data[0]);
            setMdUm(response.data[1].nomeMetaMdUm); 
            setMdDois(response.data[2].nomeMetaMdDois);
            localStorage.setItem("idMdUm",response.data[1].idMdUm);
            localStorage.setItem("idMdDois",response.data[2].idMdDois);
            console.log(response.data)
        })
        
    }, [])

    async function submitMD(data) {
        try {
            const schema = Yup.object().shape({
                tarefaMDUm: Yup.string().required("É necessário ter uma tarefa para a MD1").min(5, 'A Tarefa deve ter no minimo 5 caracteres'),
                tarefaMDDois: Yup.string().required("É necessário ter uma tarefa para MD2").min(5, 'A Tarefa  deve ter no minimo 5 caracteres'),
            });
            await schema.validate(data, {
                abortEarly: false
            })
            formRef.current.setErrors({});
            const nomeTarefaMdUm = data.tarefaMDUm;
            const nomeTarefaMdDois = data.tarefaMDDois;

            const idDx = localStorage.getItem('id');
            const idMd = localStorage.getItem('idMdUm');    
            const idMdDois = localStorage.getItem('idMdDois');
            try {
                await api.post(`metodosdxs/4dx/${idDx}/mdUm/${idMd}`, { nomeTarefaMdUm }, config).then(response => console.log(response.data))
                await api.post(`metodosdxs/4dx/${idDx}/mdDois/${idMdDois}`, { nomeTarefaMdDois }, config).then(response => {
                    
                    if (response.status == 201) {
                        setOpenTask(false)
                        setTimeout(() => {
                            setGood(true)
                        }, 500);
                        setTimeout(() => {
                            setGood(false)
                        }, 2000);
                    }
                    else {
                        setTimeout(() => {
                            setBad(true)
                        }, 500);
                        setTimeout(() => {
                            setBad(false)
                        }, 2000);
                    }
                    console.log(response.data)
                });

            } catch (err) {
              console.log(err)
            }
          
        }
        catch (err) {
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

    async function trazerTaresfas() {
        setIsOpenTask(true)
        const id = localStorage.getItem('id');
        const response = await api.get(`metodosdxs/tarefas/${id}`, config);
        console.log(response)
        setArrayMdDois(response.data[1]);
        setArrayMdUm(response.data[2]);
    }
    

    return (
        <>
            <SideBar />
            <Body>
                <AlignHo space>
                    <Func onClick={() => setOpenTask(true)}
                        >Cadastrar Tarefas
                        </Func>
                    <Func onClick={trazerTaresfas}
                            >Visualizar Tarefas
                        </Func>
                </AlignHo>
                <AlignH>
                    <AlignV>
                        <WeekMetrics title="MD1" description={mdUm} />
                    </AlignV>
                    <Suport>
                        <WeekMetrics mci title="MCI" description={data.nomeMci} />
                        {teste(data.semanas)}
                        <Img src={Bau} />
                    </Suport>
                    <AlignV>
                        <WeekMetrics title="MD2" description={mdDois} />
                    </AlignV>
                </AlignH>
                <Foot>
                    <LegendTemplate />
                </Foot>
            </Body>

            <ModalCpt
                openModal={() => setOpenTask(true)}
                closeModal={() => setOpenTask(false)}
                isOpen={openTask}
                children={
                    <>
                        <SuplementarText>Cadastre sua Tarefa </SuplementarText>
                        <Form ref={formRef} onSubmit={submitMD}>
                            <InputTemplate
                                type="text"
                                name="tarefaMDUm"
                                labelName="Digite sua tarefa da Md1:"
                                placeholder="Digite sua tarefa"
                                messageError="Pesquisar sobre o mercado financeiro"
                            />
                            <InputTemplate
                                type="text"
                                name="tarefaMDDois"
                                labelName="Digite sua tarefa da Md2:"
                                placeholder="Enviar os dados da nova Empresa"
                            />

                            <ButtonCpt
                                type="submit"
                                text="Criar"
                                icon={<IoMdAdd size={20} />}

                            />
                        </Form>
                    </>
            
                }
            />

            <ModalCpt
                openModal={trazerTaresfas}
                closeModal={() => setIsOpenTask(false)}
                isOpen={modalIsOpenTask}
                children={
                    <AlignV>
                        <SuplementarText>Suas Tarefas</SuplementarText>
                        <AlignHo mds>
                        <div>
                                <Text> MD1 </Text>
                        {arrayMdUm.map((info) => {
                            return (
                                <>  
                                    <Container> {info.nomeTarefaMdUm} </Container>
                               </>
                                )
                        })}
                            </div>
                        <div>
                                <Text>MD2</Text>
                        {arrayMdDois.map((info, idx) => {
                            return (
                                <>
                                    <Container
                                        key={idx}
                                    > {info.nomeTarefaMdDois} </Container>
                                </>
                            )
                        })}
                            </div>
                        </AlignHo>
                    </AlignV>
                }
            />

            {isGood && <ResponseCard responseGood="Tarefas criadas com sucesso" color="good" height={70} respGood={true} respBad={false} />}
            {isBad && <ResponseCard responseBad="Falha ao criar as tarefas" color="bad" height={70} respGood={false} respBad={true} />}

        </>
    )
}
