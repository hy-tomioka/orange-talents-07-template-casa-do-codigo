package br.com.zupacademy.yudi.casadocodigo.estado;

import br.com.zupacademy.yudi.casadocodigo.estado.dto.NovoEstadoRequest;
import br.com.zupacademy.yudi.casadocodigo.estado.dto.NovoEstadoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager em;
    private final ProibeNomeDuplicadoParaMesmoPais proibeNomeDuplicadoParaMesmoPais;

    public EstadoController(ProibeNomeDuplicadoParaMesmoPais proibeNomeDuplicadoParaMesmoPais) {
        this.proibeNomeDuplicadoParaMesmoPais = proibeNomeDuplicadoParaMesmoPais;
    }

    @InitBinder
    public void initBinders(WebDataBinder binder) {
        binder.addValidators(proibeNomeDuplicadoParaMesmoPais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NovoEstadoResponse> cadastrar(@RequestBody @Valid NovoEstadoRequest request) {
        EstadoEntity estado = request.toModel(em);
        em.persist(estado);
        return ResponseEntity.ok(new NovoEstadoResponse(estado));
    }
}
