package br.com.organize.organizespring.controller;

import br.com.organize.organizespring.cliente.ClienteViaCep;
import br.com.organize.organizespring.dto.TarefaDto;
import br.com.organize.organizespring.form.TarefaForm;
import br.com.organize.organizespring.model.Cep;
import br.com.organize.organizespring.model.CheckList;
import br.com.organize.organizespring.model.Tarefa;
import br.com.organize.organizespring.repository.CheckListRepository;
import br.com.organize.organizespring.repository.TarefaRepository;
import br.com.organize.organizespring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/checklists")
public class CheckListController {

    @Autowired
    private CheckListRepository checkListRepository;

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private ClienteViaCep clienteViaCep;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity listarTarefas(Authentication authentication) {
        List<Tarefa> tarefas = repository.todosAsTarefas(usuarioService.checklistUsuario(authentication, checkListRepository));
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping("/tarefa")
    public ResponseEntity<TarefaDto> cadastarTarefa(@RequestBody TarefaForm form, UriComponentsBuilder uriBuilder, Authentication authentication) {
        Tarefa tarefa = form.converter();
        CheckList checkList = checkListRepository.getOne(usuarioService.checklistUsuario(authentication, checkListRepository));
        tarefa.setCheckList(checkList);
        repository.save(tarefa);
        URI uri = uriBuilder.path("/checklists/tarefa/{id}").buildAndExpand(tarefa.getIdTarefa()).toUri();
        return ResponseEntity.created(uri).body(new TarefaDto(tarefa));
    }

    @PutMapping("/tarefa/{id}")
    @Transactional
    public ResponseEntity<TarefaDto> atualizaTarefa(@PathVariable Integer id, @RequestBody TarefaForm form) {
        Optional<Tarefa> optional = repository.findById(id);
        if (optional.isPresent()) {
            Tarefa tarefa = form.atualizar(id, repository);
            return ResponseEntity.ok(new TarefaDto(tarefa));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/tarefa/{id}")
    @Transactional
    public ResponseEntity deletaTarefa(@PathVariable("id") Integer id) {
        Optional<Tarefa> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/tarefa/ativa")
    public ResponseEntity listarTarefasTrue(Authentication authentication) {
        List<Tarefa> tarefas = repository.todosAsTarefas(usuarioService.checklistUsuario(authentication, checkListRepository));

        int contadorTrue = 0;

        for (Tarefa tarefinha: tarefas) {
            if (tarefinha.getStatusTarefa() == true){
                contadorTrue++;
            }
        }

        return ResponseEntity.ok(contadorTrue);
    }

    @GetMapping("/tarefa/id/ativa")
    public ResponseEntity listarIdsTarefasTrue(Authentication authentication) {
        List<Tarefa> tarefas = repository.todosAsTarefas(usuarioService.checklistUsuario(authentication, checkListRepository));
        List<Integer> ids = new ArrayList<>();

        for (Tarefa tarefinha: tarefas) {
            if (tarefinha.getStatusTarefa() == true){
                ids.add(tarefinha.getIdTarefa());
            }
        }

        return ResponseEntity.ok(ids);
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity consultarCep(@PathVariable String cep) {
        Cep cepEncontrado = clienteViaCep.getCep(cep);
        return ResponseEntity.ok(cepEncontrado);
    }

}