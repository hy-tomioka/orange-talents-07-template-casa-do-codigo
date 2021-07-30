package br.com.zupacademy.yudi.casadocodigo.autor.dto;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorEntity;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    @UniqueValue(domainClass = AutorEntity.class, fieldName = "email")
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public AutorEntity toModel() {
        return new AutorEntity(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return this.email;
    }
}
