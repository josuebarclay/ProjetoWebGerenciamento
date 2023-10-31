package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.DTO.EmailDTO;
import com.autocom.helpdesk.model.EmailModel;
import com.autocom.helpdesk.repository.EmailRepository;
import com.autocom.helpdesk.service.EmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/autocom")
public class AutocomController {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    EmailService emailService;


    @GetMapping("/autocom")
    public ModelAndView autocomHome() {
        ModelAndView mv = new ModelAndView("autocom/autocom");
        return mv;
    }

    @GetMapping("/relatorio")
    public ModelAndView relatorioContatos() {
        ModelAndView mv = new ModelAndView("autocom/relatorio-contato");
        List<EmailModel> contatos = emailRepository.findAll();
        mv.addObject("contatos", contatos);
        return mv;
    }

    @PostMapping("/envio-email")
    public String envioEmail(@Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
        return "redirect:/autocom/sucessoEmail";
    }

    @GetMapping("/sucessoEmail")
    public ModelAndView sucessoEmail() {
        ModelAndView mv = new ModelAndView("sucesso/sucesso-email");
        return mv;
    }


}

