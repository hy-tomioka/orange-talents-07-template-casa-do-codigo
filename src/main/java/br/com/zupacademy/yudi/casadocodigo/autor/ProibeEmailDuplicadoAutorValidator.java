package br.com.zupacademy.yudi.casadocodigo.autor;

import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    private AutorRepository autorRepository;

    public ProibeEmailDuplicadoAutorValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;
        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<AutorEntity> autorOptional = autorRepository.findByEmail(request.getEmail());
        if (autorOptional.isPresent()) {
            errors.rejectValue("email",null, "E-mail já cadastrado.");
        }
    }
}
