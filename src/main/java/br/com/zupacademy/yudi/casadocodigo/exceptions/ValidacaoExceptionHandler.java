package br.com.zupacademy.yudi.casadocodigo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidacaoExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handleErroDeValidacao(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return buildErroDeFormulario(fieldErrors);
    }

    private List<ErroDeFormularioDto> buildErroDeFormulario(List<FieldError> fieldErrors) {
        List<ErroDeFormularioDto> erros = new ArrayList<>();
        fieldErrors.forEach(e -> {
            String mensagem = e.getDefaultMessage();
            erros.add(new ErroDeFormularioDto(e.getField(), mensagem));
        });
        return erros;
    }
}
