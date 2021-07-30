package br.com.zupacademy.yudi.casadocodigo.cadastro.dto;

import br.com.zupacademy.yudi.casadocodigo.cadastro.CategoriaEntity;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    private String nome;

    @Deprecated
    private NovaCategoriaRequest() {
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaEntity toModel() {
        return new CategoriaEntity(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
