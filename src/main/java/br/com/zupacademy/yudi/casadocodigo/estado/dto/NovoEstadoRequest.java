package br.com.zupacademy.yudi.casadocodigo.estado.dto;

import br.com.zupacademy.yudi.casadocodigo.estado.EstadoEntity;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.ExistsId;
import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = PaisEntity.class)
    private Long paisId;

    public EstadoEntity toModel(EntityManager em) {
        PaisEntity pais = em.find(PaisEntity.class, paisId);
        return new EstadoEntity(nome, pais);
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
