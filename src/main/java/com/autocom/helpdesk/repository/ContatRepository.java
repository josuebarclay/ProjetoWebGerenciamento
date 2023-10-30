package com.autocom.helpdesk.repository;

import com.autocom.helpdesk.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatRepository extends JpaRepository<Contact, Integer> {


}
