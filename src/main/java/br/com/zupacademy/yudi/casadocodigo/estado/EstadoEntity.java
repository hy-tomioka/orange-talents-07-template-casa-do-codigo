package br.com.zupacademy.yudi.casadocodigo.estado;

import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

import javax.persistence.*;

@Entity
@Table(name = "estado")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false, name = "pais_id")
    private PaisEntity pais;

    @Deprecated
    private EstadoEntity() {
    }

    public EstadoEntity(String nome, PaisEntity pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPaisNome() {
        return pais.getNome();
    }
}
