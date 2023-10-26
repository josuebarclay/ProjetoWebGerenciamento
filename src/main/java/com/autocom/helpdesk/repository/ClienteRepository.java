package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional <Cliente> findByEmail(String email);

}