package br.com.zupacademy.yudi.casadocodigo.pais.dto;

import br.com.zupacademy.yudi.casadocodigo.generico.validacao.UniqueValue;
import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = PaisEntity.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }
}
