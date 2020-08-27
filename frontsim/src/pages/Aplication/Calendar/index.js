import React, { useState, useEffect, useRef } from 'react';
import { Form } from '@unform/web';
import * as Yup from 'yup';
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid";
import * as moment from 'moment';
import { IoMdAdd } from "react-icons/io";


import {
    Box,
    AlignH,
    PageTitle,
    AlignV,
    SuplementarText,
    Suport
} from './styles.js'

import SideBar from '~/components/SideBar'
import Collapase from '~/components/Collapse'
import EventCard from '~/components/EventCard'
import ButtonCpt from '~/components/Button'
import ModalCpt from '~/components/Modal'
import InputTemplate from '~/components/InputTemplate'
import SelectBox from '~/components/SelectBox'
import ResponseCard from '~/components/ResponseCard'

import api from '~/services/api'


import "./custom.css";

export default function Calendar() {
    const [modalIsOpen, setIsOpen] = useState(false);

    const [listUrgent, setListUrgent] = useState([])

    const [isGood, setGood] = useState(false);
    const [isBad, setBad] = useState(false);

    const [listMedium, setListMedium] = useState([])
    const [listLow, setListLow] = useState([])

    const [isDataList, setDataList] = useState([]);
    const formRef = useRef(null);
    const [selectValue, setSelectValue] = useState('baixa');
    const _ = moment();

    const token = localStorage.getItem('token')
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };

    useEffect(() => {
        api.get("/calendarios", config).then(response => {
            setDataList(response.data)
        })
        api.get("/calendarios/evento/alta", config).then(response => {
            setListUrgent(response.data)
        })
        api.get("/calendarios/evento/media", config).then(response => {
            setListMedium(response.data)
        })
        api.get("/calendarios/evento/baixa", config).then(response => {
            setListLow(response.data)
            console.log(response.data)
        })

    }, [])
    async function handleSubmit(data) {
        try {
            const schema = Yup.object().shape({
                beginDate: Yup.date().required("É necessário ter uma data de início").typeError("Data de início é necessária"),
                finalDate: Yup.date().required("É necessário ter uma data final").typeError("Data final é necessária"),
                descricao: Yup.string().required("É necessário ter uma curta descrição.").min(3, 'A descrição deve conter pelo menos 3 caracteres').max(20, 'A descrição deve conter no máximo 20 caracteres'),
                cep: Yup.string().required("É necessário passar o cep do local")            
            });
            await schema.validate(data, {
                abortEarly: false
            })
            formRef.current.setErrors({});
            const dataInicio = data.beginDate;
            const dataFinal = data.finalDate;
            const descricao = data.descricao;
            const prioridade = selectValue;

            const cep = data.cep;
            
            let response = await api.get(`checklists/cep/${cep}`, config)
            let local = response.data.logradouro;
           
            await api.post('/calendarios/evento', { dataFinal, dataInicio, cep, local, descricao, prioridade }, config).then(response => {
                
                if (response.status == 201) {
                    setIsOpen(false)
                    setTimeout(() => {
                        setGood(true)
                    }, 500);
                    setTimeout(() => {
                        setGood(false)
                        window.location.reload()
                    }, 2000);
                }
                else {
                    setTimeout(() => {
                        setBad(true)
                    }, 500);
                    setInterval(() => {
                        setBad(false)
                    }, 2000);
                }
        
            });
        
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

    async function deleteEvent(idx) {
        api.delete(`/calendarios/evento/${idx}`, config).then(response => {
            console.log(response.data)
            window.location.reload();
        })
    }
    return (
        <>
        <AlignH>
            <SideBar />

            <div class="teste" >
                <FullCalendar
                    defaultView="dayGridMonth"
                    plugins={[dayGridPlugin]}
                    headerToolbar={{
                        left: 'prev',
                        center: 'title',
                        right: 'next'
                    }}
                    titleFormat={{ month: 'long' }}
                    allDay = {false}
                    eventColor= {'#746CBC'}
                    displayEventTime={false} 
                    events={isDataList.map(event => {
                        return {
                            id: event.idEvento,
                            title: event.descricao,
                            // start: event.dataInicio,
                            start: moment(event.dataInicio).add({hours: _.hour()+10}).toDate(),
                            end: moment(event.dataFinal).add({hours: _.hour()+9}).toDate(),
                            
                            // end: event.dataFinal,
                        }
                    })}
                    locale="br"
                />
            </div>
            <AlignV>
                <PageTitle> Calendário </PageTitle>
                <ButtonCpt
                    type="submit"
                    text="Criar MD's"
                    width={200}
                    height={43}
                    back
                    icon={<IoMdAdd size={20} />}
                    onClick={() => setIsOpen(true)}
                />

            <Box>
                    <Collapase
                        widhBox={300}
                        urgency={1}
                        labelName="Alta Prioridade"
                        body={
                            listUrgent.map((value) => {
                                return(
                                <EventCard
                                    description={value.descricao}
                                        finalDate={moment(value.dataFinal).format('DD/MM/yyyy')}
                                    place={value.local}
                                    onClickFinish={()=> deleteEvent(value.idEvento)}    
                                />)
                            })}
                        />
                    <Collapase
                        labelName="Media Prioridade"
                        widhBox={300}
                        urgency={2}
                        body={
                            listMedium.map((value) => {
                                return (
                                    <EventCard
                                        description={value.descricao}
                                        finalDate={moment(value.dataFinal).format('DD/MM/yyyy')}
                                        place={value.local}
                                        onClickFinish={() => deleteEvent(value.idEvento)}    
                                    />)
                            })
                        }
                        />
                    <Collapase
                        labelName="Baixa Prioridade"
                        widhBox={300}
                        body={
                            listLow.map((value) => {
                                return (
                                    <EventCard
                                        description={value.descricao}
                                        finalDate={moment(value.dataFinal, ).format('DD/MM/yyyy')}
                                        place={value.local}
                                        onClickFinish={() => deleteEvent(value.idEvento)}    
                                    />)
                            })
                        }
                    />
                </Box>
            </AlignV>
            </AlignH>

            <ModalCpt
                openModal={() => setIsOpen(true)}
                closeModal={() => setIsOpen(false)}
                isOpen={modalIsOpen}
                children={
                    <>
                        <SuplementarText>Crie um Evento</SuplementarText>
                        <Suport>
                            <Form ref={formRef} onSubmit={handleSubmit}>
                                <AlignH>
                                <InputTemplate
                                    type="date"
                                    name="beginDate"
                                    labelName="Digite uma data de inicio:"
                                    placeholder="Data de inicio"
                                    width={168}
                                />
                                <InputTemplate
                                    type="date"
                                    name="finalDate"
                                    labelName="Digite uma data final:"
                                    placeholder="Data final"
                                    width={168}

                                />
                                </AlignH>
                                <InputTemplate
                                    type="text"
                                    name="descricao"
                                    labelName="Digite uma curta descricao:"
                                    placeholder="Digite uma descrição de 3 a 20 caracteres"
                                />

                                <AlignH>
                                <SelectBox
                                    width={130}
                                    value={selectValue}
                                    onChange={event => setSelectValue(event.target.value)}
                                    type="select"
                                    labelName="Nível de Importância:"
                                    />
                                    <InputTemplate
                                        width={200}
                                        type="text"
                                        name="cep"
                                        labelName="Digite o cep do local:"
                                        placeholder="Digite o cep do local"
                                        maxLength={8}
                                    />
                                </AlignH>

                                
                                <ButtonCpt
                                    type="submit"
                                    text="Criar Evento"
                                    icon={<IoMdAdd size={20} />}
                                />
                            </Form>
                        </Suport>
                       
                    </>
                }
            />

            {isGood &&
                <ResponseCard responseGood="  Evento marcado com sucesso"
                    color="good"
                    respGood={true}
                    respBad={false}
                />}

            {isBad &&
                <ResponseCard responseBad="  Falha ao marcar o evento"
                    width={220}
                    height={42}
                    respGood={false}
                    respBad={true}
                />
            }
        </>
    );


}
