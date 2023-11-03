package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

    Optional<Visita> findById(Integer id);

    @Query("SELECT v FROM Visita v WHERE v.dataRetorno30Dias <= :dataAtual")
    List<Visita> findByDataRetorno30DiasLessThanEqual(@Param("dataAtual") LocalDate dataAtual);


    List<Visita> findByDataRetorno30DiasBetween(LocalDate dataInicial, LocalDate dataFinal);
}
