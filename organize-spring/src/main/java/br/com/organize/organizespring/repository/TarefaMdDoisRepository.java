package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.MdDois;
import br.com.organize.organizespring.model.TarefaMdDois;
import br.com.organize.organizespring.model.TarefaMdUm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TarefaMdDoisRepository extends JpaRepository<TarefaMdDois, Integer> {

    @Query(value="select * from tarefa_md_dois where md_dois_id_md_dois = ?1", nativeQuery =true)
    List<TarefaMdDois> listaTarefasMd (Integer idMdDois);

    @Query(value="select id_tarefa_md_dois top1 from tarefa_md_dois where md_dois_id_md_dois = ?1", nativeQuery =true)
    List<Integer> tarefaExistente(Integer idMdDois);

    @Modifying
    @Transactional
    @Query(value="delete from tarefa_md_dois where md_dois_id_md_dois = ?1", nativeQuery =true)
    void deletaTarefa (Integer idMdDois);
}
