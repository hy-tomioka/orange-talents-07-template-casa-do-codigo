package br.com.zupacademy.yudi.casadocodigo.estado;

import br.com.zupacademy.yudi.casadocodigo.estado.dto.NovoEstadoRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class ProibeNomeDuplicadoParaMesmoPais implements Validator {

    private final EstadoRespository estadoRespository;

    public ProibeNomeDuplicadoParaMesmoPais(EstadoRespository estadoRespository) {
        this.estadoRespository = estadoRespository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoEstadoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;
        NovoEstadoRequest request = (NovoEstadoRequest) target;
        List<EstadoEntity> possiveisEstados = estadoRespository.findByNomeAndPaisId(request.getNome(),
                request.getPaisId());
        if (possiveisEstados.size() >= 1)
            errors.rejectValue("nome", null, "Estado já cadastrado para este país.");
    }
}
