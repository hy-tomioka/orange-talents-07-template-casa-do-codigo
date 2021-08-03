package br.com.zupacademy.yudi.casadocodigo.cliente;

import br.com.zupacademy.yudi.casadocodigo.cliente.dto.NovoClienteRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class ProibeNuloParaPaisComEstado implements Validator {

    @PersistenceContext
    private EntityManager em;

    private NovoClienteRequest request;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors())
            return;
        request = (NovoClienteRequest) target;
        List<Long> estadosDoPais = buscaEstadoPorPaisId(request.getPaisId());

        if (!estadosDoPais.isEmpty()) {
            if (estadoIsNull())
                errors.rejectValue("estadoId", null,
                        "É necessário selecionar um estado para este país.");
            else if (!estadoIsNull() && estadoExists(estadosDoPais))
                errors.rejectValue("estadoId", null,
                        "Estado inexistente para este país.");
        }
    }

    private List<Long> buscaEstadoPorPaisId(Long paisId) {
        Query query = em.createQuery("select e.id from EstadoEntity e where e.pais.id = :pvalue");
        query.setParameter("pvalue", paisId);
        List<Long> estadosDoPais = query.getResultList();
        return estadosDoPais;
    }

    private boolean estadoIsNull() {
        return request.getEstadoId() == null;
    }

    private boolean estadoExists(List<Long> estados) {
        return !estados.stream().anyMatch(id -> id.equals(request.getEstadoId()));
    }
}
