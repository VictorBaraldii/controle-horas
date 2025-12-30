package io.github.victorbaraldii.controle.controle_horas.dto;

import org.springframework.web.multipart.MultipartFile;

public class RegistroHoraDTO {

    private String descricao;
    private Double horas;
    private String nomePessoa;
    private MultipartFile anexo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public MultipartFile getAnexo() {
        return anexo;
    }

    public void setAnexo(MultipartFile anexo) {
        this.anexo = anexo;
    }
}
