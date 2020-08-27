package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Tarefa;
import br.com.organize.organizespring.repository.TarefaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TarefaForm {

    @NotNull
    @NotEmpty
    private String nomeTarefa;
    private String nivelImportancia;
    private Boolean statusTarefa;
    private String descricaoTarefa;

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getNivelImportancia() {
        return nivelImportancia;
    }

    public void setNivelImportancia(String nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public Boolean getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(Boolean statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public Tarefa converter(){
        return new Tarefa(nomeTarefa, nivelImportancia, statusTarefa, descricaoTarefa);
    }

    public Tarefa atualizar(Integer id, TarefaRepository repository) {
        Tarefa tarefa = repository.getOne(id);
        tarefa.setDescricaoTarefa(this.descricaoTarefa);
        tarefa.setNivelImportancia(this.nivelImportancia);
        tarefa.setNomeTarefa(this.nomeTarefa);
        tarefa.setStatusTarefa(this.statusTarefa);
        return tarefa;
    }
}
