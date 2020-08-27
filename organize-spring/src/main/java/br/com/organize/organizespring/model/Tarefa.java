package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarefa;
    private String nomeTarefa;
    //AQUI VAI SER UM ENUM
    private String nivelImportancia;
    private Boolean statusTarefa;
    private String descricaoTarefa;

//    @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    private CheckList checkList;

    public Tarefa(){

    }

    public Tarefa(String nomeTarefa, String nivelImportancia, Boolean statusTarefa, String descricaoTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.nivelImportancia = nivelImportancia;
        this.statusTarefa = statusTarefa;
        this.descricaoTarefa = descricaoTarefa;
    }

    public Integer getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(Integer idTarefa) {
        this.idTarefa = idTarefa;
    }

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

    public CheckList getCheckList() {
        return checkList;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }
}
