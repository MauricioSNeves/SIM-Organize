package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.Calendario;
import br.com.organize.organizespring.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarioRepository extends JpaRepository<Calendario,Integer> {

    @Query(value="select id_calendario from Calendario where usuario_id_usuario = ?1", nativeQuery =true)
    Integer idCalendario(Long idUsuario);
}
