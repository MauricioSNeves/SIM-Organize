package br.com.organize.organizespring.controller;

import br.com.organize.organizespring.dto.EventoDto;
import br.com.organize.organizespring.form.EventoForm;
import br.com.organize.organizespring.model.Calendario;
import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.repository.CalendarioRepository;
import br.com.organize.organizespring.repository.EventoRepository;

import br.com.organize.organizespring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendarios")
public class CalendarioController {

    @Autowired
    private CalendarioRepository calendarioRepository;

    @Autowired
    private EventoRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity listarEventos(Authentication authentication){
        List<Evento> eventos = repository.todosOsEventos(usuarioService.calendarioUsuario(authentication, calendarioRepository));
        return ResponseEntity.ok(eventos);
    }

    @PostMapping("/evento")
    public ResponseEntity<EventoDto> cadastarEvento(@RequestBody EventoForm form, UriComponentsBuilder uriBuilder, Authentication authentication) {
        Evento evento = form.converter();
        Calendario calendario = calendarioRepository.getOne(usuarioService.calendarioUsuario(authentication, calendarioRepository));
        evento.setCalendario(calendario);
        repository.save(evento);
        URI uri = uriBuilder.path("/calendarios/evento/{id}").buildAndExpand(evento.getIdEvento()).toUri();
        return ResponseEntity.created(uri).body(new EventoDto(evento));
    }

    @PutMapping("/evento/{id}")
    @Transactional
    public ResponseEntity<EventoDto> atualizaEvento(@PathVariable Integer id, @RequestBody EventoForm form) {
        Optional<Evento> optional = repository.findById(id);
        if (optional.isPresent()) {
            Evento calendario = form.atualizar(id, repository);
            return ResponseEntity.ok(new EventoDto(calendario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/evento/{id}")
    @Transactional
    public ResponseEntity<?> deletaEvento(@PathVariable("id") Integer id){
        Optional<Evento> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/evento/alta")
    public ResponseEntity listarEventosPrioridadeAlta(Authentication authentication){
        List<Evento> eventos = repository.eventosAltaPrioridade(usuarioService.calendarioUsuario(authentication, calendarioRepository));
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/evento/media")
    public ResponseEntity listarEventosPrioridadeMedia(Authentication authentication){
        List<Evento> eventos = repository.eventosMediaPrioridade(usuarioService.calendarioUsuario(authentication, calendarioRepository));
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/evento/baixa")
    public ResponseEntity listarEventosPrioridadeBaixa(Authentication authentication){
        List<Evento> eventos = repository.eventosBaixaPrioridade(usuarioService.calendarioUsuario(authentication, calendarioRepository));
        return ResponseEntity.ok(eventos);
    }

}
