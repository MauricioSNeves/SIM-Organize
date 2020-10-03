package br.com.organize.organizespring.model;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class UsuarioHasMeetup {

    private Integer Usuario_idUsuario;
    private Integer Meetup_idMoeetup;
    private Boolean presenteEvento;
    private Boolean eventoAtivo;

    @ManyToMany
    private Usuario usuario;


    public UsuarioHasMeetup(Integer usuario_idUsuario, Integer meetup_idMoeetup, Boolean presenteEvento, Boolean eventoAtivo) {
        this.Usuario_idUsuario = usuario_idUsuario;
        this.Meetup_idMoeetup = meetup_idMoeetup;
        this.presenteEvento = presenteEvento;
        this.eventoAtivo = eventoAtivo;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getUsuario_idUsuario() {
        return Usuario_idUsuario;
    }

    public void setUsuario_idUsuario(Integer usuario_idUsuario) {
        Usuario_idUsuario = usuario_idUsuario;
    }

    public Integer getMeetup_idMoeetup() {
        return Meetup_idMoeetup;
    }

    public void setMeetup_idMoeetup(Integer meetup_idMoeetup) {
        Meetup_idMoeetup = meetup_idMoeetup;
    }

    public Boolean getPresenteEvento() {
        return presenteEvento;
    }

    public void setPresenteEvento(Boolean presenteEvento) {
        this.presenteEvento = presenteEvento;
    }

    public Boolean getEventoAtivo() {
        return eventoAtivo;
    }

    public void setEventoAtivo(Boolean eventoAtivo) {
        this.eventoAtivo = eventoAtivo;
    }
}
