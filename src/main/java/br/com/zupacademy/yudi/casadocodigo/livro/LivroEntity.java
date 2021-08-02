package br.com.zupacademy.yudi.casadocodigo.livro;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorEntity;
import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String titulo;
    @Column(nullable = false, length = 500)
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    private Double preco;
    @Column(nullable = false)
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String isbn;

    @Future
    private LocalDate dataDePublicacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CategoriaEntity categoria;
    @ManyToOne
    @JoinColumn(nullable = false)
    private AutorEntity autor;

    public LivroEntity(String titulo, String resumo, String sumario, Double preco, Integer numeroDePaginas, String isbn,
                       LocalDate dataDePublicacao, CategoriaEntity categoria, AutorEntity autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = autor;
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
