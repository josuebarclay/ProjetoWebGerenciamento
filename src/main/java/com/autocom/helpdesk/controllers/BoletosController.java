package com.autocom.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boletos")
public class BoletosController {

    @GetMapping("/list-boletos")
    public String login(){
        return "boletos/lista-boletos";
    }
}
