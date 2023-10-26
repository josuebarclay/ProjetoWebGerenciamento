package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Chamado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    @Query(value = "select * from chamado", nativeQuery = true)
    public Page<Chamado> findAllChamados(Pageable page);
}
