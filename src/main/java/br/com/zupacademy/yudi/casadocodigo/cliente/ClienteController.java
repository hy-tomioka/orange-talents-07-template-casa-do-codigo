package br.com.zupacademy.yudi.casadocodigo.cliente;

import br.com.zupacademy.yudi.casadocodigo.cliente.dto.NovoClienteRequest;
import br.com.zupacademy.yudi.casadocodigo.cliente.dto.NovoClienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager em;
    private final ProibeNuloParaPaisComEstado proibeNuloParaPaisComEstado;

    public ClienteController(ProibeNuloParaPaisComEstado proibeNuloParaPaisComEstado) {
        this.proibeNuloParaPaisComEstado = proibeNuloParaPaisComEstado;
    }

    @InitBinder
    public void initBinders(WebDataBinder binder) {
        binder.addValidators(proibeNuloParaPaisComEstado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NovoClienteResponse> cadastrar(@RequestBody @Valid NovoClienteRequest request) {
        ClienteEntity cliente = request.toModel(em);
        em.persist(cliente);
        return ResponseEntity.ok(new NovoClienteResponse(cliente));
    }
}
