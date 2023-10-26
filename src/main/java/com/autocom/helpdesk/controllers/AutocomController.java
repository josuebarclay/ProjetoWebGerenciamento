package com.autocom.helpdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/autocom")
public class AutocomController {

    @GetMapping("/autocom")
    public ModelAndView autocomHome(){
        ModelAndView mv = new ModelAndView("autocom/autocom");
        return mv;
    }
}
