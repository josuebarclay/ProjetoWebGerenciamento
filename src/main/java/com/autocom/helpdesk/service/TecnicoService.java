package com.autocom.helpdesk.service;

import com.autocom.helpdesk.TratamentoExep.EmailDuplicadoException;
import com.autocom.helpdesk.TratamentoExep.NomeDuplicadoException;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico saveTecnico(Tecnico tecnico) throws NomeDuplicadoException, EmailDuplicadoException {
        if (tecnicoRepository.findByNome(tecnico.getNome()).isPresent()) {
            throw new NomeDuplicadoException("Nome já em uso: " + tecnico.getNome());
        }

        if (tecnicoRepository.findByEmail(tecnico.getEmail()).isPresent()) {
            throw new EmailDuplicadoException("E-mail já em uso: " + tecnico.getEmail());
        }

        return tecnicoRepository.save(tecnico);
    }
//    Método para carregar um cliente por email:
    public Tecnico loadTecnicoByEmail(String email) {
        return tecnicoRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));
    }


}
