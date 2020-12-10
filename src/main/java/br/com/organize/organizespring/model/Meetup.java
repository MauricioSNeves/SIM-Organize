package br.com.organize.organizespring.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeetup;
    private String descricao;
    private Date data;

    @ManyToMany(mappedBy = "meetups")
    private List<Usuario> usuarios;

    public Meetup(Integer idMeetup, String descricao, Date data, List<Usuario> usuarios) {
        this.idMeetup = idMeetup;
        this.descricao = descricao;
        this.data = data;
        this.usuarios = usuarios;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
