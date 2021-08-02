package br.com.zupacademy.yudi.casadocodigo.estado.dto;

import br.com.zupacademy.yudi.casadocodigo.estado.EstadoEntity;

public class NovoEstadoResponse {

    private Long id;
    private String nome;
    private String paisNome;

    public NovoEstadoResponse(EstadoEntity estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.paisNome = estado.getPaisNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisNome() {
        return paisNome;
    }
}
