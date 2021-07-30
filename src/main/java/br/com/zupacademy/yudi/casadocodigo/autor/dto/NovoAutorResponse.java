package br.com.zupacademy.yudi.casadocodigo.autor.dto;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorEntity;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private String descricao;

    public NovoAutorResponse(AutorEntity autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
