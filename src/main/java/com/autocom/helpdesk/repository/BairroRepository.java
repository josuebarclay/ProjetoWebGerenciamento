package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Bairro;
import com.autocom.helpdesk.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {


}
