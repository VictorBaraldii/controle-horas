package io.github.victorbaraldii.controle.controle_horas.controller;

import io.github.victorbaraldii.controle.controle_horas.model.RegistroHora;
import io.github.victorbaraldii.controle.controle_horas.service.RegistroHoraService;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/registros")
public class RegistroHoraController {

    private final RegistroHoraService service;

    public RegistroHoraController(RegistroHoraService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(@RequestParam(required = false) Integer mes, @RequestParam(required = false) Integer ano, Model model) {

        List<RegistroHora> registro;

        if (mes != null && ano != null) {
            registro = service.listarPorMes(mes, ano);
        } else {
            registro = service.listar();
        }

        model.addAttribute("registros", registro);
        model.addAttribute("mes", mes);
        model.addAttribute("ano", ano);

        return "registros";
    }

    @PostMapping
    public String salvar(@ModelAttribute RegistroHora registro,
                         @RequestParam("arquivo") MultipartFile arquivo)
            throws IOException {

        if (!arquivo.isEmpty()) {

            String nomeArquivo = UUID.randomUUID() + "_" + arquivo.getOriginalFilename();

            Path pastaUploads = Paths.get("uploads");

            if (!Files.exists(pastaUploads)) {
                Files.createDirectories(pastaUploads);
            }

            Files.copy(
                    arquivo.getInputStream(),
                    pastaUploads.resolve(nomeArquivo),
                    StandardCopyOption.REPLACE_EXISTING
            );

            registro.setNomeArquivo(nomeArquivo);
        }

        service.salvar(registro);
        return "redirect:/registros";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/registros";
    }
}
