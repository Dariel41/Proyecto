package com.cafeteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaController {

    @GetMapping("/consultas/listado")
    public String listado(Model model) {
        return "consultas/listado";
    }

}