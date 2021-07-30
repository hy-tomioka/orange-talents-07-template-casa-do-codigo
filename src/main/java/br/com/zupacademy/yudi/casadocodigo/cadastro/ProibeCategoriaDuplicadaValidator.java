package br.com.zupacademy.yudi.casadocodigo.cadastro;

import br.com.zupacademy.yudi.casadocodigo.cadastro.dto.NovaCategoriaRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeCategoriaDuplicadaValidator implements Validator {

    private CategoriaRepository categoriaRepository;

    public ProibeCategoriaDuplicadaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;
        NovaCategoriaRequest request = (NovaCategoriaRequest) target;
        Optional<CategoriaEntity> categoriaOptional = categoriaRepository.findByNome(request.getNome());
        if (categoriaOptional.isPresent())
            errors.rejectValue("nome", null, "Categoria já cadastrada.");
    }
}
