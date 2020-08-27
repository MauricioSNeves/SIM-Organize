package br.com.organize.organizespring.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class MetodoDx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMetodoDx;
    private String nomeDx;
    private LocalDate dataConclusaoDx;
    private String nomeMci;
    private long semanas;
    private LocalDate dataInicioDx;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="id_usuario")
    @ManyToOne
    private Usuario usuario;

    public MetodoDx() {
    }

    public MetodoDx(String nomeDx, LocalDate  dataConclusaoDx, String nomeMci) {
        this.nomeDx = nomeDx;
        this.dataConclusaoDx = dataConclusaoDx;
        this.nomeMci = nomeMci;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdMetodoDx() {
        return idMetodoDx;
    }

    public void setIdMetodoDx(Integer idMetodoDx) {
        this.idMetodoDx = idMetodoDx;
    }

    public LocalDate  getDataConclusaoDx() {
        return dataConclusaoDx;
    }

    public void setDataConclusaoDx(LocalDate  dataConclusaoDx) {
        this.dataConclusaoDx = dataConclusaoDx;
    }

    public String getNomeMci() {
        return nomeMci;
    }

    public void setNomeMci(String nomeMci) {
        this.nomeMci = nomeMci;
    }

    public String getNomeDx() {
        return nomeDx;
    }

    public void setNomeDx(String nomeDx) {
        this.nomeDx = nomeDx;
    }

    public long getSemanas() {
        return semanas;
    }

    public void setSemanas(long semanas) {
        this.semanas = semanas;
    }

    public LocalDate getDataInicioDx() {
        return dataInicioDx;
    }

    public void setDataInicioDx(LocalDate dataInicioDx) {
        this.dataInicioDx = dataInicioDx;
    }

}
