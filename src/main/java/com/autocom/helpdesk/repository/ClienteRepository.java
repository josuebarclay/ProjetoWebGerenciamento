package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente", nativeQuery = true)
    public Page<Cliente> findAllCliente(Pageable page);

    Optional <Cliente> findByEmail(String email);

    Optional<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
