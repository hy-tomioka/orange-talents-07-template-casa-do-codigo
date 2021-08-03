package br.com.zupacademy.yudi.casadocodigo.cliente.dto;

import br.com.zupacademy.yudi.casadocodigo.cliente.ClienteEntity;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.CpfOrCnpj;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.ExistsId;
import br.com.zupacademy.yudi.casadocodigo.generico.validacao.UniqueValue;
import br.com.zupacademy.yudi.casadocodigo.pais.PaisEntity;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteRequest {

    @Email @NotBlank
    @UniqueValue(domainClass = ClienteEntity.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CpfOrCnpj
    @UniqueValue(domainClass = ClienteEntity.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;

    @NotNull
    @ExistsId(domainClass = PaisEntity.class)
    private Long paisId;
    private Long estadoId;

    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteEntity toModel(EntityManager em) {
        PaisEntity pais = em.find(PaisEntity.class, paisId);
        ClienteEntity cliente = new ClienteEntity(email, nome, sobrenome, documento, endereco, complemento, cidade,
                pais, telefone, cep);
        cliente.setEstado(em, estadoId);
        return cliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
