package br.com.organize.organizespring.repository;

import br.com.organize.organizespring.model.MdDois;
import br.com.organize.organizespring.model.MdUm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MdUmRepository extends JpaRepository<MdUm, Integer> {

    @Query(value="select * from md_um where metodo_dx_id_metodo_dx = ?1", nativeQuery =true)
    MdUm mdUm (Integer idQuatroDx);

    @Modifying
    @Transactional
    @Query(value="delete from md_um where metodo_dx_id_metodo_dx = ?1", nativeQuery =true)
    void deletaMd (Integer idQuatroDx);
}