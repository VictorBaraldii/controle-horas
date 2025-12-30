package io.github.victorbaraldii.controle.controle_horas.service;

import io.github.victorbaraldii.controle.controle_horas.model.Anexo;
import io.github.victorbaraldii.controle.controle_horas.repository.AnexoRepository;
import org.springframework.stereotype.Service;

@Service
public class AnexoService {

    private final AnexoRepository repository;

    public AnexoService(AnexoRepository repository) {
        this.repository = repository;
    }

    public Anexo salvar(Anexo anexo) {
        return repository.save(anexo);
    }

    public Anexo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anexo não encontrado"));
    }
}
