package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {

    @Query(value="select * from Tarefa where check_list_id_checklist = ?1", nativeQuery =true)
    List<Tarefa> todosAsTarefas(Integer idChecklist);
}
