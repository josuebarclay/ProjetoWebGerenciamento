package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class FiltroController {

    @Autowired
    ChamadoRepository chamadoRepository;

    @Autowired
    TecnicoRepository tecnicoRepository;

    @GetMapping("/list-filtro/{id}")
    public ModelAndView filtroTecnico(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("relatorio/list-filtro");
        Optional<Tecnico> tecnicoOptional = tecnicoRepository.findById(id);

        if (tecnicoOptional.isPresent()) {
            Tecnico tecnico = tecnicoOptional.get();
            List<Chamado> chamadosDoTecnico = chamadoRepository.findByTecnico(tecnico);
            mv.addObject("chamadoTecnico", chamadosDoTecnico);
        }
        return mv;
    }

    @PostMapping("/list-filtro")
    public ModelAndView filtroList(
            @RequestParam("tecnicoId") Integer tecnicoId,
            @RequestParam("dataInicio") String dataInicio,
            @RequestParam("dataFim") String dataFim) {
        ModelAndView mv = new ModelAndView("relatorio/list-filtro");

        try {
            LocalDate dataInicioDate = LocalDate.parse(dataInicio);
            LocalDate dataFimDate = LocalDate.parse(dataFim);

            Optional<Tecnico> tecnicoOptional = tecnicoRepository.findById(tecnicoId);

            if (tecnicoOptional.isPresent()) {
                Tecnico tecnico = tecnicoOptional.get();

                List<Chamado> chamadosDoTecnico = chamadoRepository.findByTecnicoAndDataAberturaBetween(tecnico, dataInicioDate, dataFimDate);
                mv.addObject("chamadoTecnico", chamadosDoTecnico);
            }
        } catch (DateTimeParseException e) {
            mv.addObject("mensagemErro", "Erro na conversão da data. Utilize o formato dd-mm-yyyy.");
        }

        return mv;
    }

}
