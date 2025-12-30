package io.github.victorbaraldii.controle.controle_horas.controller;

import io.github.victorbaraldii.controle.controle_horas.model.RegistroHora;
import io.github.victorbaraldii.controle.controle_horas.service.RegistroHoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/registros")
public class RegistroHoraController {

    private final RegistroHoraService service;

    public RegistroHoraController(RegistroHoraService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("registros", service.listar());
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
}
