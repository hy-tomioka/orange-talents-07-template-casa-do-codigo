package br.com.zupacademy.yudi.casadocodigo.livro.dto;

import br.com.zupacademy.yudi.casadocodigo.livro.LivroEntity;

public class DetalharLivroResponse {

    private String titulo;
    private Double preco;
    private String resumo;
    private String sumario;
    private Integer numeroDePaginas;
    private String isbn;
    private String dataDePublicacao;
    private String autorNome;
    private String autorDescricao;

    public DetalharLivroResponse(LivroEntity livro) {
        this.titulo = livro.getTitulo();
        this.preco = livro.getPreco();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataFormatada("dd/MM/yyyy");
        this.autorNome = livro.getAutorNome();
        this.autorDescricao = livro.getAutorDescricao();
    }

    public String getTitulo() {
        return titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public String getAutorDescricao() {
        return autorDescricao;
    }
}
