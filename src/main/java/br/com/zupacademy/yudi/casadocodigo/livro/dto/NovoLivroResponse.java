package br.com.zupacademy.yudi.casadocodigo.livro.dto;

import br.com.zupacademy.yudi.casadocodigo.livro.LivroEntity;

import java.time.LocalDate;

public class NovoLivroResponse {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private LocalDate dataDePublicacao;

    public NovoLivroResponse(LivroEntity livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDePublicacao = livro.getDataDePublicacao();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }
}
