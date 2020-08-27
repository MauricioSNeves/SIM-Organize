package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.Tarefa;
import br.com.organize.organizespring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);

    @Query(value="select valido from Usuario where id_usuario = ?1", nativeQuery =true)
   boolean usuarioValido(Long idUsuario);
}
