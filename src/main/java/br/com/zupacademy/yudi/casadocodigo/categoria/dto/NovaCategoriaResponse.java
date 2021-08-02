package br.com.zupacademy.yudi.casadocodigo.categoria.dto;

import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaEntity;

public class NovaCategoriaResponse {

    public Long id;
    public String nome;

    public NovaCategoriaResponse(CategoriaEntity categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
