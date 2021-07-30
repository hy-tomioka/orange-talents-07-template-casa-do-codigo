package br.com.zupacademy.yudi.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "autor")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    @NotBlank @Email @Column(unique = true, nullable = false)
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    @CreationTimestamp
    private Instant dataRegistro;

    @Deprecated
    private AutorEntity() {
    }

    public AutorEntity(@NotBlank String nome, @NotBlank @Email String email,
                       @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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
