package io.github.victorbaraldii.controle.controle_horas.controller;

import io.github.victorbaraldii.controle.controle_horas.service.AnexoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anexos")
public class AnexoController {
    private final AnexoService service;

    public AnexoController(AnexoService service) {
        this.service = service;
    }
}
