package br.com.zupacademy.yudi.casadocodigo.livro.dto;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorEntity;
import br.com.zupacademy.yudi.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaEntity;
import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.ExistsId;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.UniqueValue;
import br.com.zupacademy.yudi.casadocodigo.livro.LivroEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Optional;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = LivroEntity.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @Min(20)
    private Double preco;
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;
    @NotBlank
    @UniqueValue(domainClass = LivroEntity.class, fieldName = "isbn")
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @Future
    private LocalDate dataDePublicacao;

    @NotNull
    @ExistsId(domainClass = CategoriaEntity.class)
    private Long categoriaId;
    @NotNull
    @ExistsId(domainClass = AutorEntity.class)
    private Long autorId;

    @Deprecated
    private NovoLivroRequest() {
    }

    public NovoLivroRequest(String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas,
                            String isbn, LocalDate dataDePublicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public LivroEntity toModel(EntityManager em) {

        CategoriaEntity categoria = em.find(CategoriaEntity.class, this.categoriaId);
        AutorEntity autor = em.find(AutorEntity.class, this.autorId);

        return new LivroEntity(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas,
                this.isbn, this.dataDePublicacao, categoria, autor);
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
