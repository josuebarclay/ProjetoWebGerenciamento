package com.autocom.helpdesk.service;

import com.autocom.helpdesk.model.Visita;
import com.autocom.helpdesk.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public void calcularDataRetorno30Dias(Visita visita) {
        LocalDate dataRetorno30Dias = visita.getDataVisita().plusDays(30);
        visita.setDataRetorno30Dias(dataRetorno30Dias);
        visitaRepository.save(visita); // Salvar a visita atualizada no banco de dados
    }


    public List<Visita> getClientesParaRetorno() {
        LocalDate dataAtual = LocalDate.now();
        return visitaRepository.findByDataRetorno30DiasLessThanEqual(dataAtual);
    }

    public List<Visita> getClientesParaRetornoPorMes(int mes) {
        LocalDate dataInicial = LocalDate.now().withMonth(mes).withDayOfMonth(1);
        LocalDate dataFinal = dataInicial.plusMonths(1).minusDays(1);
        return visitaRepository.findByDataRetorno30DiasBetween(dataInicial, dataFinal);
    }

}

