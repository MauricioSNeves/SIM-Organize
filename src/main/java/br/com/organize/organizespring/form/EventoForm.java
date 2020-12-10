package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.repository.EventoRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EventoForm {

    private Date dataInicio;
    private Date dataFinal;
    private String local;
    private String descricao;
    private String prioridade;
    private Boolean status;

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Evento converter(){
        return new Evento(dataInicio, dataFinal, local, descricao, prioridade, status);
    }

    public Evento atualizar(Integer id, EventoRepository repository) {
        Evento calendario = repository.getOne(id);
        calendario.setDataInicio(this.dataInicio);
        calendario.setDataFinal(this.dataFinal);
        calendario.setDescricao(this.descricao);
        calendario.setLocal(this.local);
        calendario.setPrioridade(this.prioridade);
        calendario.setStatus(this.status);

        return calendario;
    }
}
