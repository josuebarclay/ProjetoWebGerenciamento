package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {
    Optional<Bairro> findByNomeBairro(String nomeBairro);
}

