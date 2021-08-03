package br.com.zupacademy.yudi.casadocodigo.pais;

import br.com.zupacademy.yudi.casadocodigo.estado.EstadoEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "pais")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
    private List<EstadoEntity> estados;

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

    public boolean temEstados() {
        return !estados.isEmpty();
    }
}
