package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.MdUm;
import br.com.organize.organizespring.model.TarefaMdUm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TarefaMdUmRepository extends JpaRepository<TarefaMdUm, Integer> {

    @Query(value="select * from tarefa_md_um where md_um_id_md_um = ?1", nativeQuery =true)
    List<TarefaMdUm> listaTarefasMd (Integer idMdUm);

    @Query(value="select id_tarefa_md_um top1 from tarefa_md_um where md_um_id_md_um = ?1", nativeQuery =true)
    List<Integer> tarefaExistente(Integer id);

    @Modifying
    @Transactional
    @Query(value="delete from tarefa_md_um where md_um_id_md_um = ?1", nativeQuery =true)
    void deletaTarefa (Integer idMdUm);

}
