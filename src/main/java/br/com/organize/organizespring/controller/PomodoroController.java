package br.com.organize.organizespring.controller;


import br.com.organize.organizespring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pomodoros")
public class PomodoroController {

    @Autowired
    private UsuarioRepository repository;
}