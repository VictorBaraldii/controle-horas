package io.github.victorbaraldii.controle.controle_horas.service;

import io.github.victorbaraldii.controle.controle_horas.model.RegistroHora;
import io.github.victorbaraldii.controle.controle_horas.repository.RegistroHoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroHoraService {

    private final RegistroHoraRepository repository;

    public RegistroHoraService(RegistroHoraRepository repository) {
        this.repository = repository;
    }

    public List<RegistroHora> listar() {
        return repository.findAll();
    }

    public RegistroHora salvar(RegistroHora registro) {
        return repository.save(registro);
    }

    public RegistroHora buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }
}
