package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.SimNao;
import com.autocom.helpdesk.enums.StatusVisita;
import com.autocom.helpdesk.model.Visita;
import com.autocom.helpdesk.repository.BairroRepository;
import com.autocom.helpdesk.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private VisitaRepository visitaRepository;

    @Autowired
    private BairroRepository bairroRepository;


    @GetMapping("/cadastro")
        public ModelAndView cadastro(Visita visita){
        ModelAndView mv = new ModelAndView("visita/cadastroVisita");
        mv.addObject("sim", SimNao.values());
        mv.addObject("visita", visita);
        mv.addObject("listaBairro", bairroRepository.findAll());
        mv.addObject("statusVisita", StatusVisita.values());
        return mv;
        }

    @PostMapping("/salvarvisita")
    public ModelAndView salvarVisita(@Valid Visita visita, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("visita/cadastroVisita");
            mv.addObject("sim", SimNao.values());
            mv.addObject("visita", visita);
            mv.addObject("listaBairro", bairroRepository.findAll());
            mv.addObject("statusVisita", StatusVisita.values());
            return mv;
        }
        visita.setNomeVisitante(visita.getNomeVisitante().toUpperCase());
        visita.setNomeEmpresa(visita.getNomeEmpresa().toUpperCase());
        visita.setEndereco(visita.getEndereco().toUpperCase());
        visita.setContato(visita.getContato().toUpperCase());
        visita.setInformacao(visita.getInformacao().toUpperCase());
        visita.setMotivo(visita.getMotivo().toUpperCase());
        visita.setNomeEmpresaAutomacao(visita.getNomeEmpresaAutomacao().toUpperCase());
        visita.setQualSistema(visita.getQualSistema().toUpperCase());
        visita.setTempodoSistema(visita.getTempodoSistema().toUpperCase());
        visita.setRecebimento(visita.getRecebimento().toUpperCase());
        visita.setDataRetorno(visita.getDataRetorno().toUpperCase());
        visitaRepository.save(visita);
        return new ModelAndView("redirect:/visita/list-visita");
    }


    @GetMapping("/list-visita")
    public ModelAndView visitaList(){
        ModelAndView mv = new ModelAndView("visita/lista-visita");
        mv.addObject("visitas", visitaRepository.findAll());
        return mv;
    }

    @GetMapping("/visualizar/{id}")
    public ModelAndView visualizar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView("visita/visitaDetalhada");
        Visita visita = visitaRepository.findById(id).orElse(null); // Use orElse ou orElseThrow para tratar valores nulos
        mv.addObject("visita", visita);
        return mv;
    }


    @PostMapping("/vistadetalhada")
    public ModelAndView visualizar(Visita visita) {
        visitaRepository.save(visita);
        return new ModelAndView("redirect:/visita/list-visita");
    }

}
