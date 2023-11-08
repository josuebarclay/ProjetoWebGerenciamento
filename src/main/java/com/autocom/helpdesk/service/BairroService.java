package com.autocom.helpdesk.service;

import com.autocom.helpdesk.TratamentoExep.NomeDuplicadoException;
import com.autocom.helpdesk.model.Bairro;
import com.autocom.helpdesk.repository.BairroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BairroService {

    @Autowired
    private BairroRepository bairroRepository;

    public Bairro saveBairro(Bairro bairro) throws NomeDuplicadoException {
        if (bairroRepository.findByNomeBairro(bairro.getNomeBairro()).isPresent()) {
            throw new NomeDuplicadoException("Nome já em uso: " + bairro.getNomeBairro());
        }

        return bairroRepository.save(bairro);
    }

}
