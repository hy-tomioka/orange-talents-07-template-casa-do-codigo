package br.com.zupacademy.yudi.casadocodigo.autor.dto;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorEntity;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Validated
public class NovoAutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
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
}
