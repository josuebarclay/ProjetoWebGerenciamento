package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.Prioridade;
import com.autocom.helpdesk.enums.StatusTicket;
import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/ticket")
public class Chamados {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("home")
    public ModelAndView chamadoHome(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page -1),5);
        Page<Chamado> resultPages = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPages);
        return mv;
    }

    @GetMapping("/criar")
    public ModelAndView ticket(Chamado chamado){
        ModelAndView mv = new ModelAndView("chamados/ticket");
        mv.addObject("statusChamados", StatusTicket.values());
        mv.addObject("prioridade", Prioridade.values());
        mv.addObject("tecnicos", tecnicoRepository.findAll());
        mv.addObject("tickets", chamado);
        mv.addObject("listaClientes", clienteRepository.findAll());
        return mv;
    }

    @PostMapping("/new-ticket")
    public ModelAndView newTicket(@Valid Chamado chamado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("chamados/ticket");
            mv.addObject("statusChamados", StatusTicket.values());
            mv.addObject("prioridade", Prioridade.values());
            mv.addObject("tecnicos", tecnicoRepository.findAll());
            mv.addObject("tickets", chamado);
            mv.addObject("listaClientes", clienteRepository.findAll());
            return mv;
        } else {
            chamadoRepository.save(chamado);
            return chamadoHome(1);
        }
    }



}
