package br.com.organize.organizespring.service;

import br.com.organize.organizespring.controller.UsuarioController;
import br.com.organize.organizespring.model.Usuario;
import br.com.organize.organizespring.repository.CalendarioRepository;
import br.com.organize.organizespring.repository.CheckListRepository;
import br.com.organize.organizespring.util.ListaObj;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;

@Service
public class UsuarioService {

    public Long usuarioAtual(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        return logado.getIdUsuario();
    }

    public Integer calendarioUsuario(Authentication authentication, CalendarioRepository calendarioRepository) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Integer idCalendario = calendarioRepository.idCalendario(logado.getIdUsuario());
        return idCalendario;
    }

    public Integer checklistUsuario(Authentication authentication, CheckListRepository checklistRepository) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Integer idChecklist = checklistRepository.idChecklist(logado.getIdUsuario());
        return idChecklist;
    }

}
