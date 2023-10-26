package com.autocom.helpdesk.controllers;

import com.autocom.helpdesk.enums.Perfil;
import com.autocom.helpdesk.model.Bairro;
import com.autocom.helpdesk.model.Cliente;
import com.autocom.helpdesk.model.Tecnico;
import com.autocom.helpdesk.repository.BairroRepository;
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
@RequestMapping("/bairro")
public class BairroController {

    @Autowired
    BairroRepository bairroRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastrobairro(Bairro bairro){
        ModelAndView mv = new ModelAndView("visita/cadastroBairro");
        mv.addObject("bairro", bairro);
        return mv;
    }

    @PostMapping("/salvarbairro")
    public ModelAndView salvarBairro(@Valid Bairro bairro, BindingResult br) {
        ModelAndView mv = new ModelAndView();

        if (br.hasErrors()) {
            mv.setViewName("visita/cadastroBairro");
            mv.addObject("bairro", bairro);
        } else {
            mv.setViewName("redirect:/bairro/list-bairro");
            bairroRepository.save(bairro);
        }

        return mv;
    }


    @GetMapping("/list-bairro")
    public ModelAndView bairroList(){
        ModelAndView mv = new ModelAndView("visita/lista-bairro");
        mv.addObject("bairro", bairroRepository.findAll());
        return mv;
    }

    //EXCLUIR BAIRRO
    @GetMapping("/excluir/{id}")
    public ModelAndView excluirBairro(@PathVariable("id") Integer id){
        bairroRepository.deleteById(id);
        return bairroList();
    }

}
