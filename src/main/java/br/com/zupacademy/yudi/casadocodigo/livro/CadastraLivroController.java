package br.com.zupacademy.yudi.casadocodigo.livro;

import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroRequest;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class CadastraLivroController {

    @PersistenceContext
    private EntityManager em;
    private final LivroRepository livroRepository;

    public CadastraLivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest request) {
        LivroEntity livro = request.toModel(em);
        livroRepository.save(livro);
        return ResponseEntity.ok(new NovoLivroResponse(livro));
    }
}
