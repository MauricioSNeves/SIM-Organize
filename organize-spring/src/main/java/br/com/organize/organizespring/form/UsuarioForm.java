package br.com.organize.organizespring.form;

import br.com.organize.organizespring.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UsuarioForm {

    @NotNull @NotEmpty
    private String nomeUser;
    @NotNull @NotEmpty
    private String tipoAcesso;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String senha;
    private String cpf;

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public Usuario converter() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(senha);

        return new Usuario(nomeUser, tipoAcesso, email, encodedPassword, cpf);
    }
}
