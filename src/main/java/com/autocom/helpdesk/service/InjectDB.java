package com.autocom.helpdesk.service;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.TecnicoRepository;
import com.autocom.helpdesk.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class InjectDB {

    @Autowired
    private TecnicoRepository tecnicoRepository;


    public void injectDB(){
        Tecnico tecnico1 = new Tecnico(null,"supervisor","supervisor@gmail.com", PasswordUtil.encoder("123"),null,Perfil.TECNICO,null);

        tecnicoRepository.saveAll(Arrays.asList(tecnico1));
    }

}
