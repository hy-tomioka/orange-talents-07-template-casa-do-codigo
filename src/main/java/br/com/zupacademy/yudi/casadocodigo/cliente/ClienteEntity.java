package br.com.zupacademy.yudi.casadocodigo.cliente;

import br.com.zupacademy.yudi.casadocodigo.estado.EstadoEntity;
import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Email @NotBlank private String email;

    @Column(nullable = false)
    @NotBlank private String nome;

    @Column(nullable = false)
    @NotBlank private String sobrenome;

    @Column(unique = true, nullable = false)
    @NotBlank private String documento;

    @Column(nullable = false)
    @NotBlank private String endereco;

    @Column(nullable = false)
    @NotBlank private String complemento;

    @Column(nullable = false)
    @NotBlank private String cidade;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    @NotNull private PaisEntity pais;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = true)
    private EstadoEntity estado;

    @Column(nullable = false)
    @NotBlank private String telefone;

    @Column(nullable = false)
    @NotBlank private String cep;

    @Deprecated
    private ClienteEntity() {
    }

    public ClienteEntity(String email, String nome, String sobrenome, String documento, String endereco,
                         String complemento, String cidade, PaisEntity pais, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public void setEstado(EntityManager em, Long estadoId) {
        if (pais.temEstados()) {
            this.estado = em.find(EstadoEntity.class, estadoId);
        }
    }
}
