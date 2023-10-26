package com.autocom.helpdesk.service;

import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.model.ClienteUserDetailsImpl;
import com.autocom.helpdesk.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteUserDetailsService implements UserDetailsService {

    @Autowired
    ClienteRepository clienteRepository;

    //Usuario autenticado por email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario nao encontrado na base de dados"));
        return new ClienteUserDetailsImpl(cliente);
    }
}
