package br.com.zupacademy.yudi.casadocodigo.cadastro.dto;

import br.com.zupacademy.yudi.casadocodigo.cadastro.CategoriaEntity;

public class NovaCategoriaResponse {

    public Long id;
    public String nome;

    public NovaCategoriaResponse(CategoriaEntity categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }
}
