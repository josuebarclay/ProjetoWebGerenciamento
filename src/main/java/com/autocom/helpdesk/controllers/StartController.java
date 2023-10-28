package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.model.ResetPasswordUserDao;
import com.autocom.helpdesk.model.Chamado;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.ChamadoRepository;
import com.autocom.helpdesk.repository.ClienteRepository;
import com.autocom.helpdesk.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class StartController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;



    @GetMapping("/")
    public ModelAndView start(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page -1),5);
        Page<Chamado> resultPages = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPages);
        mv.addObject("tecnicos", tecnicoRepository.findAll());
        return mv;
    }


    @GetMapping("/redefinir-senha")
    public ModelAndView resetPassord(Principal principal){
        ModelAndView mv = new ModelAndView("home/resetPassword");
        Tecnico tecnicoAuth = this.tecnicoRepository.findByEmail(principal.getName()).get();
        ResetPasswordUserDao currentSenhaDao = new ResetPasswordUserDao(tecnicoAuth.getSenha());
        mv.addObject("senhaAtual", currentSenhaDao);
        mv.addObject("resetPasswordUserDao", new ResetPasswordUserDao());
        mv.addObject("tecnicos", tecnicoRepository.findAll());
        return mv;
    }

}
