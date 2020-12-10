package br.com.organize.organizespring.controller;


import br.com.organize.organizespring.model.Usuario;
import br.com.organize.organizespring.repository.UsuarioRepository;
import br.com.organize.organizespring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levels")
public class LevelController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{xp}")
    public void aumentarLevel(@PathVariable("xp") Integer xp, Authentication authentication){

        Usuario usuario = repository.getOne(usuarioService.usuarioAtual(authentication));
        usuario.getLevel().setQtdXp(xp);

        Integer qtdeMaximaXp = usuario.getLevel().getNumero() * (usuario.getLevel().getNumero() - 1);

        if (usuario.getLevel().getQtdXp() == qtdeMaximaXp){
            usuario.getLevel().setNumero(usuario.getLevel().getNumero() + 1);

            switch(usuario.getLevel().getNumero()){
                case 10: case 20:
                case 30: case 40:
                case 50: case 60:
                case 70: case 80:
                case 90: case 100:
                    usuario.setMoedas(usuario.getMoedas() + 100);
                    break;
                default:
                    usuario.setMoedas(usuario.getMoedas() + 10);
                    break;
            }
            usuario.getLevel().setQtdXp(0);
        }
        ResponseEntity.ok().build();
    }
}
