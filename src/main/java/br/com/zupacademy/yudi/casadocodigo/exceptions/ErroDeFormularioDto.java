package br.com.zupacademy.yudi.casadocodigo.exceptions;

public class ErroDeFormularioDto {

    private String field;
    private String mensagem;

    public ErroDeFormularioDto(String field, String mensagem) {
        this.field = field;
        this.mensagem = mensagem;
    }

    public String getField() {
        return field;
    }

    public String getMensagem() {
        return mensagem;
    }
}
