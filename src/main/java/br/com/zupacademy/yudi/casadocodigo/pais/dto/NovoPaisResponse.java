package br.com.zupacademy.yudi.casadocodigo.pais.dto;

import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

public class NovoPaisResponse {

    private Long id;
    private String nome;

    public NovoPaisResponse(PaisEntity pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
