package br.com.zupacademy.yudi.casadocodigo.livro.dto;

import br.com.zupacademy.yudi.casadocodigo.livro.LivroEntity;

public class ListaLivroResponse {

    private Long id;
    private String titulo;

    public ListaLivroResponse(LivroEntity livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
