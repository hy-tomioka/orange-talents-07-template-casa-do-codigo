package br.com.zupacademy.yudi.casadocodigo.categoria.dto;

import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaEntity;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = CategoriaEntity.class, fieldName = "nome")
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
