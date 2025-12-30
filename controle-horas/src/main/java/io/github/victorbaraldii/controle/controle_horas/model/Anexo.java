package io.github.victorbaraldii.controle.controle_horas.model;

import jakarta.persistence.*;


@Entity
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeOriginal;
    private String nomeSalvo;
    private String caminho;

    public RegistroHora getRegistroHora() {
        return registroHora;
    }

    public void setRegistroHora(RegistroHora registroHora) {
        this.registroHora = registroHora;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getNomeSalvo() {
        return nomeSalvo;
    }

    public void setNomeSalvo(String nomeSalvo) {
        this.nomeSalvo = nomeSalvo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    @ManyToOne
    private RegistroHora registroHora;
}
