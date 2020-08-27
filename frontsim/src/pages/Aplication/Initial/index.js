import React, {useState, useRef,useEffect} from 'react'
import { Form } from '@unform/web';
import * as Yup from 'yup';
import { GrAdd } from "react-icons/gr";
import { FiUploadCloud } from "react-icons/fi";
import { IoMdAdd } from "react-icons/io";

import {
    Img,
    Text,
    Body,
    Card,
    Suport,
    Paragraph,
    LinkTo,
    TextCard,
    PageTitle,
    AlignH,
    AlignV,
    SuplementarText
} from './styles'

import SideBar from '~/components/SideBar';


import ButtonCpt from '~/components/Button'
import InputTemplate from '~/components/InputTemplate'
import Slide from '~/components/Slide'
import ModalCpt from '~/components/Modal'
import MuralDx from '~/components/MuralDx'
import ResponseCard from '~/components/ResponseCard'

import pensar from '~/assets/pensar.png'

import api from '~/services/api'

export default function Inital() {
    const [isGoodDelete, setGoodDelete] = useState(false);
    const [isBadDelete, setBadDelete] = useState(false);

    const [isGoodExport, setGoodExport] = useState(false);
    const [isBadExport, setBadExport] = useState(false);

    const [isGoodImport, setGoodImport] = useState(false);
    const [isBadImport, setBadImport] = useState(false);

    const [upload, setUpload] = useState(false)

    const [partOne, setPartOne] = useState(true)
    const [partTwo, setPartTwo] = useState(false)

    const [openDx, setOpenDx] = useState(false)
    const [modalIsOpen, setIsOpen] = useState(false);
    const [data, setData] = useState([])
    const token = localStorage.getItem('token')

    const formRef = useRef(null);
    const config = {
        headers: { Authorization: `Bearer ${token}` }
    };


    async function handleSubmit(data) {
        try {
            const schema = Yup.object().shape({
                name: Yup.string().required("É necessário ter um nome na sua tarefa").min(3, 'O nome deve conter pelo menos 3 caracteres').max(20, 'O Nome deve conter no máximo 20 caracteres'),
                mci: Yup.string().required("É necessário ter uma MCI para o 4dx, lembre-se, é o seu objetivo final ").min(10, 'A MCI deve ter no minimo 10 caracteres'),
                dataFinal: Yup.date().required("É necessário a data final.").typeError("Data final é necessária")
            });
            await schema.validate(data, {
                abortEarly: false
            })
            formRef.current.setErrors({});
            const nomeDx = data.name;
            const dataConclusaoDx = data.dataFinal;
            const nomeMci = data.mci;
            let response = await api.post('metodosdxs/4dx', { nomeDx, nomeMci, dataConclusaoDx }, config);

            localStorage.setItem("idDx", response.data.idMetodoDx)
            setPartOne(false)
            setPartTwo(true)
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

    async function handleSubmitMd(data) {
        try {
            const schema = Yup.object().shape({
                mdUm: Yup.string().required("É necessário ter uma MD1 para o 4dx").min(10, 'A MD1 deve ter no minimo 10 caracteres'),
                mdDois: Yup.string().required("É necessário ter uma MD2 para o 4dx").min(10, 'A MD2 deve ter no minimo 10 caracteres'),
            });
            await schema.validate(data, {
                abortEarly: false
            })
            formRef.current.setErrors({});
            const nomeMetaMdUm = data.mdUm;
            const nomeMetaMdDois = data.mdDois;

            const id = localStorage.getItem("idDx");

            await api.post(`metodosdxs/4dx/${id}/mdUm`, { nomeMetaMdUm }, config);
            await api.post(`metodosdxs/4dx/${id}/mddois`, { nomeMetaMdDois }, config).then(response => {

                if (response.status == 201) {
                    setTimeout(() => {
                        return (
                            <ResponseCard responseGood="4dx criado com sucesso" respGood={true} respBad={false} />
                        )
                    }, 4000);
                    setIsOpen(false)
                    window.location.reload()
                }
                else {
                    setIsOpen(false)
                    setTimeout(() => {
                        return (
                            <ResponseCard responseBad="Falha ao criar 4dx" respGood={false} respBad={true} />
                        )
                    }, 4000);
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

    async function deletar(id) {
        await api.delete(`metodosdxs/4dx/${id}`, config).then(response => {
            if (response.status === 200) {
                setTimeout(() => {
                    setGoodDelete(true)
                }, 500);
                setTimeout(() => {
                    setGoodDelete(false)
                    window.location.reload()
                }, 2000);
            
            } else {
                setTimeout(() => {
                    setBadDelete(true)
                }, 500);
                setInterval(() => {
                    setBadDelete(false)
                }, 4000);
            }
            console.log(response)
        })
    }

    async function exportDx(id) {
        api.defaults.headers['Authorization'] = `Bearer ${token}` 
        await api.post(`metodosdxs/exportar/${id}`).then(response => {
            if (response.status === 201) {
                setTimeout(() => {
                    setGoodExport(true)
                }, 500);
                setTimeout(() => {
                    setGoodExport(false)
                    window.location.reload()
                }, 2000);

            } else {
                setTimeout(() => {
                    setBadExport(true)
                }, 500);
                setInterval(() => {
                    setBadExport(false)
                }, 2000);
            }
            console.log(response)
        })
    }

    async function importDx() {
        await api.get('metodosdxs/importar', config).then(response => {
            if (response.status === 201) {
                setTimeout(() => {
                    setGoodImport(true)
                }, 500);
                setTimeout(() => {
                    setGoodImport(false)
                    window.location.reload()
                }, 2000);

            } else {
                setTimeout(() => {
                    setBadImport(true)
                }, 500);
                setInterval(() => {
                    setBadImport(false)
                }, 2000);
            }
            console.log(response)
        })
    }

    useEffect(() => {
        api.get('metodosdxs', config).then(response => { setData(response.data); console.log(response.data); })
    }, [])

    return (
        <>
            <SideBar />
            <Body>
                <AlignH>
                    <AlignV>
                        <AlignH width space>
                            <Card onClick={importDx}>
                                <AlignV center>
                                    <FiUploadCloud size={20} />
                                    <Text>Importar 4DX</Text>
                                </AlignV>
                            </Card>
                            <Card onClick={() => setIsOpen(true)}>
                                <AlignV center>
                                    <GrAdd size={20} />
                                    <Text>Criar 4DX</Text>
                                </AlignV>
                            </Card>

                            {data.map((info, idx) => {
                             return (
                                <MuralDx
                                    onClick={() => localStorage.setItem('id', info.idMetodoDx)}
                                    linkTo={"initial/4dx/" + info.idMetodoDx}
                                    name={info.nomeDx}
                                    deletarDx={() => deletar(info.idMetodoDx)}       
                                    exportarDx={()=> exportDx(info.idMetodoDx)} 
                                />
                                )
                            })} 
                    
                        </AlignH>
                    </AlignV>

                    <AlignV center>
                        <PageTitle>4DX</PageTitle>

                        <Img src={pensar} />
                        
                        <Paragraph onClick={()=>{setOpenDx(true)}}>
                            Afinal o que é 4dx?
                        </Paragraph>
                        
                    </AlignV> 
                </AlignH>

                <ModalCpt
                    openModal={()=>setIsOpen(true)}
                    closeModal={() => setIsOpen(false)}
                    isOpen={modalIsOpen}
                    children={
                        <>
                            <SuplementarText>Crie seu 4dx</SuplementarText>
                            <Suport display={partOne}>
                                <Form ref={formRef} onSubmit={handleSubmit}>
                                <InputTemplate
                                    type="text"
                                    name="name"
                                    labelName="De um nome para o seu 4dx:"
                                    placeholder="Digite um nome"
                                />
                                <InputTemplate
                                    type="text"
                                    name="mci"
                                    labelName="Digite sua MCI, o seu objetivo final:"
                                    placeholder="Digite um titulo"
                                    messageError="Ex: Quero montar meu primeiro negócio até 22/08/2020"
                                />

                                <InputTemplate
                                    type="date"
                                    name="dataFinal"
                                    labelName="Digite a data de conclusão:"
                                    placeholder="Digite um titulo"
                                />
                                <ButtonCpt
                                    type="submit"
                                        text="Criar 4DX"
                                        icon={<IoMdAdd size={20}/>}
                                    />
                                </Form>
                            </Suport>
                                <Suport display={partTwo}>
                                <Form ref={formRef} onSubmit={handleSubmitMd}>
                                    <InputTemplate
                                        type="text"
                                        name="mdUm"
                                        labelName="Digite sua MD1, sua primeira medida de direção:"
                                        placeholder="Digite sua MD1"
                                        messageError="Ex: Estudar semanalmente um tópico importante de Empreendedorismo"
                                    />
                                    <InputTemplate
                                        type="text"
                                        name="mdDois"
                                        labelName="Digite sua MD2,  sua segunda medida de direção:"
                                        placeholder="Digite sua MD2"
                                        messageError="Ex: Realizar semanalmente tarefas burocráticas da futura empresa"
                                    />
                                    <ButtonCpt
                                        type="submit"
                                        text="Criar MD's"
                                        icon={<IoMdAdd size={20} />}
                                    />
                                    </Form>
                                </Suport>
                        </>
                    }
                />


                <ModalCpt
                    openModal={() => setOpenDx(true)}
                    closeModal={() => setOpenDx(false)}
                    isOpen={openDx}
                    children={<Slide/>}
                />

                <ModalCpt
                    openModal={() => setUpload(true)}
                    closeModal={() => setUpload(false)}
                    isOpen={upload}
                    children={
                        <Form ref={formRef}>
                            <SuplementarText>Upload seu 4dx</SuplementarText>
                        <InputTemplate
                            name="file"
                            placeholder="upload seu 4dx"
                            top={10}
                            type="file"
                            />
                            <ButtonCpt
                                type="submit"
                                text="Enviar"
                            />
                    </Form>


                    }
                />
                {isGoodDelete &&
                    <ResponseCard responseGood="  4dx deletado com sucesso"
                    color="good"    
                    respGood={true}
                    respBad={false}
                    />
                }
                {isBadDelete && <ResponseCard
                    responseBad="  Falha ao deletar o 4dx" color="bad" respGood={false} respBad={true} />}

                {isGoodExport &&
                    <ResponseCard responseGood="  Exportação concluida com sucesso!"
                    color="good"
                    width={260}
                    height={60}
                        respGood={true} respBad={false}
                    />
                }
                
                {isBadExport && <ResponseCard color="bad" responseBad="  Falha ao exportar o 4dx" respGood={false} respBad={true} />}
                
                {isGoodImport && <ResponseCard color="good"  responseGood="  Exportação concluida com sucesso!" color="good" respGood={true} respBad={false} />}
                {isBadImport &&  <ResponseCard color="bad" responseBad="  Falha ao exportar o 4dx" respGood={false} color="bad" respBad={true} />}

            </Body>
            
        </>
    )
}
