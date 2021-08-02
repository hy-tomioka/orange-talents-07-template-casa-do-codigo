package br.com.zupacademy.yudi.casadocodigo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pais")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @Deprecated
    private PaisEntity() {
    }

    public PaisEntity(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
