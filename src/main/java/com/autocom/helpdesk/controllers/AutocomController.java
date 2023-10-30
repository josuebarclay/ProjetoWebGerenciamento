package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.model.Contact;
import com.autocom.helpdesk.repository.ContatRepository;
import com.autocom.helpdesk.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    ContatRepository contatRepository;

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
        List<Contact> contatos = contatRepository.findAll();
        mv.addObject("contatos", contatos);
        return mv;
    }

    @PostMapping("/contact")
    public ModelAndView contat(@Valid Contact contact, BindingResult br) {
        ModelAndView mv = new ModelAndView("autocom/autocom");

        if (br.hasErrors()) {
            mv.addObject("usuario", contact);
        } else {
            // Salve o contato no banco de dados
            contatRepository.save(contact);

            // Envie um e-mail de confirmação
            String to = "suporte3@autocominformatica.com";
            String subject = "Novo contato recebido";
            String text = "Um novo contato foi recebido. Nome: " + contact.getNome() + ", Email: " + contact.getEmail();
            emailService.sendEmail(to, subject, text);

            // Redirecione para a página de sucesso
            mv.setViewName("autocom/autocom");
            mv.addObject("mensagem", "Contato enviado com sucesso para a equipe de vendas!");
        }

        return mv;
    }

}

