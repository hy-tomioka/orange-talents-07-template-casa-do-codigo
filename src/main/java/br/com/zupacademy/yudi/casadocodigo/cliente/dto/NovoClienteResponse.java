package br.com.zupacademy.yudi.casadocodigo.cliente.dto;

import br.com.zupacademy.yudi.casadocodigo.cliente.ClienteEntity;

public class NovoClienteResponse {

    private Long id;

    public NovoClienteResponse(ClienteEntity cliente) {
        this.id = cliente.getId();
    }

    public Long getId() {
        return id;
    }
}
