package com.autocom.helpdesk.service;

import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.model.TecnicoUserDetailsImpl;
import com.autocom.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TecnicoUserDetailsService implements UserDetailsService {

    @Autowired
    TecnicoRepository tecnicoRepository;

    //Usuario autenticado por email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Tecnico tecnico = tecnicoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado na base de dados"));
        return new TecnicoUserDetailsImpl(tecnico);
    }
}
