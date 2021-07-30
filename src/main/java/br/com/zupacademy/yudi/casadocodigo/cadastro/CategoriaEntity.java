package br.com.zupacademy.yudi.casadocodigo.cadastro;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true, nullable = false)
    private String nome;

    @Deprecated
    private CategoriaEntity() {
    }

    public CategoriaEntity(@NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
