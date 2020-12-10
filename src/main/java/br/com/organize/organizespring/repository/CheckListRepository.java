package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Integer> {

    @Query(value="select id_checklist from check_list where usuario_id_usuario = ?1", nativeQuery =true)
    Integer idChecklist(Long idUsuario);

}