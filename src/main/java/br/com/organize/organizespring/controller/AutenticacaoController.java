package br.com.organize.organizespring.controller;

import br.com.organize.organizespring.repository.UsuarioRepository;
import br.com.organize.organizespring.service.TokenService;
import br.com.organize.organizespring.dto.TokenDto;
import br.com.organize.organizespring.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

@CrossOrigin
@EnableWebMvc
@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);

            boolean valido = usuarioRepository.usuarioValido(tokenService.getIdUsuario(token));

            if(valido) {
                return ResponseEntity.ok(new TokenDto(token, "Bearer"));
            }else {
                return ResponseEntity.status(550).body("Confirme seu email");
            }

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
