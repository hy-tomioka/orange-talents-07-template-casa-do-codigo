package br.com.zupacademy.yudi.casadocodigo.autor;

import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest request) {
        AutorEntity autor = request.toModel();
        em.persist(autor);
        return ResponseEntity.ok().build();
    }
}
