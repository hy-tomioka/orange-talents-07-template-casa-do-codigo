package br.com.zupacademy.yudi.casadocodigo.generico.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

    private final MessageSource messageSource;

    public ValidacaoExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
            @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeFormularioDto> handleErroDeValidacao(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return buildErroDeFormulario(fieldErrors);
    }

    private List<ErroDeFormularioDto> buildErroDeFormulario(List<FieldError> fieldErrors) {
        List<ErroDeFormularioDto> erros = new ArrayList<>();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            erros.add(new ErroDeFormularioDto(e.getField(), mensagem));
        });
        return erros;
    }
}
