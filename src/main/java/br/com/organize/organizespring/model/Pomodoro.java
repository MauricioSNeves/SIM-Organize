package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class Pomodoro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPomodoro;
    private Boolean concluido;
    private String tempoFoco;
    private Boolean favorito;
    private Boolean modoStayFocused;

    public Pomodoro() {

    }

    public Pomodoro(Integer idPomodoro, Boolean concluido, String tempoFoco, Boolean favorito, Boolean modoStayFocused, Usuario usuario) {
        this.idPomodoro = idPomodoro;
        this.concluido = concluido;
        this.tempoFoco = tempoFoco;
        this.favorito = favorito;
        this.modoStayFocused = modoStayFocused;
        this.usuario = usuario;
    }

    @ManyToOne
    private Usuario usuario;

    public Integer getIdPomodoro() {
        return idPomodoro;
    }

    public void setIdPomodoro(Integer idPomodoro) {
        this.idPomodoro = idPomodoro;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public String getTempoFoco() {
        return tempoFoco;
    }

    public void setTempoFoco(String tempoFoco) {
        this.tempoFoco = tempoFoco;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    public Boolean getModoStayFocused() {
        return modoStayFocused;
    }

    public void setModoStayFocused(Boolean modoStayFocused) {
        this.modoStayFocused = modoStayFocused;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}