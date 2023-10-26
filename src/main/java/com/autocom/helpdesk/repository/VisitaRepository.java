package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

    Optional<Visita> findById(Integer id);

}
