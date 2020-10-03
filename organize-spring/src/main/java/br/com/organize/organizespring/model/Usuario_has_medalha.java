package br.com.organize.organizespring.model;

import javax.persistence.Entity;

@Entity
class Usuario_has_Medalha {

    private Usuario usuario;
    private Medalha medalha;
    private Level level;

    public Usuario_has_Medalha(Usuario usuario, Medalha medalha, Level level) {
        this.usuario = usuario;
        this.medalha = medalha;
        this.level = level;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Medalha getMedalha() {
        return medalha;
    }

    public void setMedalha(Medalha medalha) {
        this.medalha = medalha;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
