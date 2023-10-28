package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Tecnico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

    @Query(value = "select * from chamado", nativeQuery = true)
    public Page<Chamado> findAllChamados(Pageable page);

    List<Chamado> findByTecnico(Tecnico tecnico);

    List<Chamado> findByTecnicoAndDataAberturaBetween(Tecnico tecnico, LocalDate dataInicio, LocalDate dataFim);
}
