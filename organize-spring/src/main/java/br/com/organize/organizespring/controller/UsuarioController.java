package br.com.organize.organizespring.controller;

import br.com.organize.organizespring.dto.UsuarioDto;
import br.com.organize.organizespring.form.UsuarioForm;
import br.com.organize.organizespring.model.*;
import br.com.organize.organizespring.repository.CalendarioRepository;
import br.com.organize.organizespring.repository.CheckListRepository;
import br.com.organize.organizespring.repository.LevelRepository;
import br.com.organize.organizespring.repository.UsuarioRepository;
import br.com.organize.organizespring.service.UsuarioService;
import br.com.organize.organizespring.util.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class
UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private CheckListRepository checkListRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UsuarioService usuarioService;

    private FilaObj<Usuario> fila;

    @GetMapping
    public List listaUsuaios() {
        List<Usuario> usuarios = repository.findAll();
        return usuarios;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastraUsuario
            (@RequestBody @Valid UsuarioForm form,
             UriComponentsBuilder uriBuilder) {

        Optional<Usuario> usuarioExistente = repository.findByEmail(form.getEmail());

       if(usuarioExistente.isPresent()) {
          return ResponseEntity.status(550).body("Email Existente");
        } else {
            Usuario usuario = form.converter();

            Calendario calendario = new Calendario();
            calendario.setUsuario(usuario);

            CheckList checkList = new CheckList();
            checkList.setUsuario(usuario);

            Level level = new Level();
            level.setUsuario(usuario);

            repository.save(usuario);
            calendarioRepository.save(calendario);
            checkListRepository.save(checkList);
            levelRepository.save(level);

            enviaEmail(usuario, form.getEmail());

            URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
            return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
        }
    }


    @GetMapping("/email")
    public String enviaEmail(Usuario usuario, String email) {
        SimpleMailMessage message = new SimpleMailMessage();

//        message.setTo("primeupteste@gmail.com");
        message.setTo(usuario.getEmail());
        message.setFrom(email);
        message.setSubject("Organize");
        message.setText("Confirme sua conta : "+ "https://organize.hopto.org/usuarios/confirmar-conta/"+usuario.getIdUsuario());

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }

    @GetMapping("/confirmar-conta/{id}")
    public RedirectView validaConta(@PathVariable Long id){

        Usuario usuario = repository.getOne(id);

        usuario.setValido(true);
        repository.save(usuario);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:3000/login");
        return redirectView;
    }

    @PostMapping("/evento/{capacidade}/{idUsuario}")
    public ResponseEntity entradaEvento(@PathVariable("capacidade") Integer capacidade, @PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = repository.getOne(idUsuario);
        fila = new FilaObj<>(capacidade);
        if (usuario != null) {
            fila.insert(usuario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/brindes")
    public ResponseEntity entregaBrindesEvento() {
        fila.pool();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/atualizar-senha/{email}/senha")
    public ResponseEntity atualizarSenha(@PathVariable("email") String email, @PathVariable("senha") String senha) {
       Optional<Usuario> usuario = repository.findByEmail(email);
       if (usuario.isPresent()){
           usuario.get().setSenha(senha);
           return ResponseEntity.ok().build();
       }
       return ResponseEntity.notFound().build();
    }

}