package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.MdDois;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MdDoisRepository extends JpaRepository<MdDois, Integer> {
    @Query(value="select * from md_dois where metodo_dx_id_metodo_dx = ?1", nativeQuery =true)
    MdDois mdDois (Integer idQuatroDx);

    @Modifying
    @Transactional
    @Query(value="delete from md_dois where metodo_dx_id_metodo_dx = ?1", nativeQuery =true)
    void deletaMd (Integer idQuatroDx);
}
