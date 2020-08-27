import React, { useState, useRef, useEffect } from 'react';
import { Form } from '@unform/web';
import { IoMdAdd } from "react-icons/io";

import {
    AlignH,
    AlignV,
    Suport,
    Container,
    PageTitle,
    SuplementarText
} from './styles.js'

import ButtonCpt from '~/components/Button'
import TextArea from '~/components/TextArea'
import SelectBox from '~/components/SelectBox'
import InputTemplate from '~/components/InputTemplate'
import CheckListCard from '~/components/ChecklistCard'
import SideBar from '~/components/SideBar'
import ModalCpt from '~/components/Modal'
import ResponseCard from '~/components/ResponseCard'


import api from '~/services/api'
import { colors } from '~/styles/index.js';

export default function Checklist() {
    const [valueTextArea, setValueTextArea] = useState('');
    const [selectValue, setSelectValue] = useState('baixa');
    const [titulo, setTitulo] = useState('');

    const [isGood, setGood] = useState(false);
    const [isBad, setBad] = useState(false);

    const [isGoodEdit, setGoodEdit] = useState(false);
    const [isBadEdit, setBadEdit] = useState(false);

    const [isGoodDone, setGoodDone] = useState(false);
    const [isBadDone, setBadDone] = useState(false);

    const [isGoodDelete, setGoodDelete] = useState(false);
    const [isBadDelete, setBadDelete] = useState(false);

    const [isDataList, setDataList] = useState([]);

    const [open, setOpen] = useState(false)

    const token = localStorage.getItem('token')
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };
    const formRef = useRef(null);

    function deleting(idx) {

        const id = isDataList[idx].idTarefa;
        api.delete(`checklists/tarefa/${id}`, config).then(response => {
            
            if (response.status == 200) {
                setTimeout(() => {
                    setGoodDelete(true)
                }, 500);
                setTimeout(() => {
                    setGoodDelete(false)
                }, 3000);

                setTimeout(() => {
                    window.location.reload()
                }, 3500);

            }
            else {
                setTimeout(() => {
                    setBadDelete(true)
                }, 500);
                setInterval(() => {
                    setBadDelete(false)
                }, 4000);
            }
        })
    }

    function finish(idx) {
        const id = isDataList[idx].idTarefa;
        api.delete(`checklists/tarefa/${id}`, config).then(response => {

            if (response.status == 200) {
                setTimeout(() => {
                    setGoodDone(true)
                }, 500);
                setTimeout(() => {
                    setGoodDone(false)
                    window.location.reload()
                }, 2000);

            }
            else {
                setTimeout(() => {
                    setBadDone(true)
                }, 500);
                setInterval(() => {
                    setBadDone(false)
                }, 2000);
            }
        })
    }
    
    async function submitChecklist(data) {
            
            const nomeTarefa = titulo;
            const descricaoTarefa = valueTextArea;
            const nivelImportancia = selectValue;
            const statusTarefa = false;

            if (nomeTarefa == "") { console.log("Pelo menos digite uma tarefa") }
        
        
            const response = await api.post('checklists/tarefa', {
                nomeTarefa, descricaoTarefa, nivelImportancia, statusTarefa
            }, config)
            
            if (response.status == 201) {
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
                }, 4000);
            }
    }
      
    useEffect(() => {
            api.get('checklists', config).then(response => setDataList(response.data))
    }, [])

    function editing(idx) {
        setOpen(true);
        localStorage.setItem('idValor', idx)
    }

    async function handleEdit() {
       
            formRef.current.setErrors({});
            const nomeTarefa = titulo;
            const descricaoTarefa = valueTextArea;
            const nivelImportancia = selectValue;
            const statusTarefa = false;
            const idx =localStorage.getItem('idValor')

            const id = isDataList[idx].idTarefa;

            const response = await api.put(`checklists/tarefa/${id}`, {
                nomeTarefa, descricaoTarefa, nivelImportancia, statusTarefa
            }, config);
            if (response.status == 200) {
                setOpen(false);
                setTimeout(() => {
                    setGoodEdit(true)
                }, 500);
                setTimeout(() => {
                    setGoodEdit(false)
                    window.location.reload()
                }, 2000);
            }
            else {
                setOpen(false)
                setTimeout(() => {
                    setBadEdit(true)
                }, 500);
                setInterval(() => {
                    setBadEdit(false)
                }, 4000);
                console.log(response)
            }
    
    }
   
    return (
        <AlignH>
            <SideBar/>
            <Suport> 
                <SuplementarText>Crie sua tarefa</SuplementarText>
                <Form ref={formRef} onSubmit={submitChecklist}>
                    <InputTemplate
                        type="text"
                        name="name"
                        labelName="Digite um titulo"
                        placeholder="Digite um titulo"
                        onChange={(event) => setTitulo(event.target.value)}
                    />
                    
                    <SelectBox
                        value={selectValue}
                        onChange={event=> setSelectValue(event.target.value)}
                        type="Text"
                        labelName="Nível de Importância"
                    />

                <TextArea
                    labelName="Digite uma descrição"
                        placeholder="Digite uma descrição"
                        valueTextArea={valueTextArea}
                        onChange={event => setValueTextArea(event.target.value)}
                />
                
                    <ButtonCpt
                        type="submit"
                        text="Criar"
                        icon={<IoMdAdd size={20} color={colors.primaryWhite}/>}
                    />
                </Form>
            </Suport> 

                
            <Suport> 
                <AlignV>
                    <PageTitle> Checklist </PageTitle>

                </AlignV>

                <Container >
                    {isDataList.map((task, id) => {
                        return(
                            <>
                                < CheckListCard
                                    key={id}
                                    title={task.nomeTarefa}
                                    description={task.descricaoTarefa}
                                    importance={task.nivelImportancia}
                                    delet={() => deleting(id)}
                                    edit={() => editing(id)}
                                    vai={() => finish(id)}    
                                />
                            </>
                            )
                        })
                    }
                </Container>
             </Suport > 

            
            <ModalCpt
                openModal={() => setOpen(true)}
                closeModal={() => setOpen(false)}
                isOpen={open}
                children={

                    <Suport>
                        <SuplementarText top >Editando sua tarefa numero: </SuplementarText>
                        <Form ref={formRef} onSubmit={handleEdit}>
                            <InputTemplate
                                type="text"
                                value={titulo}
                                name="tituloEdit"
                                labelName="Digite um titulo"
                                placeholder="Digite um titulo"
                                onChange={(event) => setTitulo(event.target.value)}
                            />

                            <SelectBox
                                value={selectValue}
                                onChange={event => setSelectValue(event.target.value)}
                                type="Text"
                                labelName="Nível de Importância"
                            />

                            <TextArea
                                labelName="Digite uma descrição"
                                placeholder="Digite uma descrição"
                                valueTextArea={valueTextArea}
                                onChange={event => setValueTextArea(event.target.value)}
                            />

                            <ButtonCpt
                                type="submit"
                                text="Salvar alterações"
                            />
                        </Form>
                    </Suport> 
                }
            />
            {isGood &&
                <ResponseCard responseGood="Tarefa criada com sucesso"
                color="good"
                respGood={true}
                respBad={false}
            />}

            {isBad &&
                <ResponseCard responseBad="Falha ao criar a tarefa"
                    width={220}
                    height={42}
                    respGood={false}
                    respBad={true}    
                />
            }

            {isGoodDelete &&
                <ResponseCard responseGood="  Tarefa deletada com sucesso"
                    color="good"
                    respGood={true}
                    respBad={false}
                />
            }
            {isBadDelete &&
                <ResponseCard responseBad="  Falha ao deletar a tarefa"
                    width={230}
                    height={42}
                    color="bad"    
                    respGood={false}
                    respBad={true}
                />
            }

            {isGoodEdit &&
                <ResponseCard responseGood="  Tarefa editada com sucesso"
                    color="good"
                    respGood={true}
                    respBad={false}
                />
            }
            {isBadEdit &&
                <ResponseCard responseBad="  Falha ao editar a tarefa"
                    color="bad"
                    respGood={false}
                    respBad={true}
                />
            }

            {isGoodDone &&
                <ResponseCard
                    color="good"
                    responseGood="   Parabéns mais uma tarefa finalizada!!"
                    respGood={true} respBad={false}
                />
            }
            {isBadDone &&
                <ResponseCard responseBad=" Falha ao tentar finalizar a tarefa"
                    width={260}
                    color="bad"
                    respGood={false}
                    respBad={true}
                />
            }
        </AlignH>
        
    )
}
