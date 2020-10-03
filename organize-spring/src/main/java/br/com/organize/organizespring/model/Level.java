package br.com.organize.organizespring.model;

import javax.persistence.*;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLevel;
    private Integer numero;
    private Integer qtdXp;

    public Level() {

    }

    public Level(Integer idLevel, Integer numero, Integer qtdXp, Usuario usuario) {
        this.idLevel = idLevel;
        this.numero = numero;
        this.qtdXp = qtdXp;
        this.usuario = usuario;
    }

    @OneToOne
    private Usuario usuario;

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getQtdXp() {
        return qtdXp;
    }

    public void setQtdXp(Integer qtdXp) {
        this.qtdXp = qtdXp;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
