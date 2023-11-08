package com.autocom.helpdesk.service;

import com.autocom.helpdesk.TratamentoExep.EmailDuplicadoException;
import com.autocom.helpdesk.TratamentoExep.NomeDuplicadoException;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente cliente) throws NomeDuplicadoException, EmailDuplicadoException {
        if (clienteRepository.findByNome(cliente.getNome()).isPresent()) {
            throw new NomeDuplicadoException("Nome já em uso: " + cliente.getNome());
        }

        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new EmailDuplicadoException("E-mail já em uso: " + cliente.getEmail());
        }

        return clienteRepository.save(cliente);
    }
//    Método para carregar um cliente por email:
    public Cliente loadClienteByEmail(String email) {
        return clienteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));
    }
}
