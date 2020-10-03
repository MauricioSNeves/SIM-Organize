package br.com.organize.organizespring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeetup;
    private String descricao;
    private Date data;

    @ManyToOne
    private UsuarioHasMeetup usuarioHasMeetup;

    public Meetup(Integer idMeetup, String descricao, Date data) {
        this.idMeetup = idMeetup;
        this.descricao = descricao;
        this.data = data;
    }

    public Integer getIdMeetup() {
        return idMeetup;
    }

    public void setIdMeetup(Integer idMeetup) {
        this.idMeetup = idMeetup;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public UsuarioHasMeetup getUsuarioHasMeetup() {
        return usuarioHasMeetup;
    }

    public void setUsuarioHasMeetup(UsuarioHasMeetup usuarioHasMeetup) {
        this.usuarioHasMeetup = usuarioHasMeetup;
    }
}
