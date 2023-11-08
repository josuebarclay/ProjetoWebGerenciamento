package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//cuida do salvamento do tecnico
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

    Optional <Tecnico> findByEmail(String email);

    Optional<Tecnico> findByNome(String nome);
}
