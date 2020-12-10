package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento,Integer> {

    @Query(value="select * from Evento where calendario_id_calendario = ?1", nativeQuery =true)
    List<Evento> todosOsEventos(Integer idCalendario);

    @Query(value="select * from Evento where calendario_id_calendario = ?1 and prioridade = 'alta'", nativeQuery =true)
    List<Evento> eventosAltaPrioridade(Integer idCalendario);

    @Query(value="select * from Evento where calendario_id_calendario = ?1 and prioridade = 'media'", nativeQuery =true)
    List<Evento> eventosMediaPrioridade(Integer idCalendario);

    @Query(value="select * from Evento where calendario_id_calendario = ?1 and prioridade = 'baixa'", nativeQuery =true)
    List<Evento> eventosBaixaPrioridade(Integer idCalendario);
}
