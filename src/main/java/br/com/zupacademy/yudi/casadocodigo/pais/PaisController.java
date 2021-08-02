package br.com.zupacademy.yudi.casadocodigo.pais;

import br.com.zupacademy.yudi.casadocodigo.pais.dto.NovoPaisRequest;
import br.com.zupacademy.yudi.casadocodigo.pais.dto.NovoPaisResponse;
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
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoPaisResponse> cadastrar(@RequestBody @Valid NovoPaisRequest request) {
        PaisEntity pais = new PaisEntity(request.getNome());
        em.persist(pais);
        return ResponseEntity.ok(new NovoPaisResponse(pais));
    }
}
