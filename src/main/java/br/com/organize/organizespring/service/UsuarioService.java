package br.com.organize.organizespring.service;

import br.com.organize.organizespring.controller.UsuarioController;
import br.com.organize.organizespring.model.Usuario;
import br.com.organize.organizespring.repository.CalendarioRepository;
import br.com.organize.organizespring.repository.CheckListRepository;
import br.com.organize.organizespring.repository.UsuarioRepository;
import br.com.organize.organizespring.util.ListaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Long usuarioAtual(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        return logado.getIdUsuario();
    }

    public Integer calendarioUsuario(Authentication authentication, CalendarioRepository calendarioRepository) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Integer idCalendario = calendarioRepository.idCalendario(logado.getIdUsuario());
        return idCalendario;
    }

    public Integer checklistUsuario(Long id, CheckListRepository checklistRepository) {
        Optional<Usuario> logado = usuarioRepository.findById(id);
        if (logado.isPresent()) {
            Integer idChecklist = checklistRepository.idChecklist(logado.get().getIdUsuario());
            return idChecklist;
        }else {
            return null;
        }
    }

}