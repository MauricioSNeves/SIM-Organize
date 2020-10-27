package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.Evento;
import br.com.organize.organizespring.model.MetodoDx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MetodoDxRepository extends JpaRepository<MetodoDx, Integer> {

    @Query(value="select * from metodo_dx where usuario_id_usuario = ?1", nativeQuery =true)
    List<MetodoDx> todosOsQuatroDx(Long idUsuario);

    @Query(value="select id_metodo_dx from metodo_dx where nome_dx =?1", nativeQuery =true)
    Integer ultimoQuatroDx(String nomeDx);

//    @Query(value="select * from metodo_dx where usuario_id_usuario = ?1", nativeQuery =true)
//    List<MetodoDx> todosOsQuatroDx(Long idUsuario);

}