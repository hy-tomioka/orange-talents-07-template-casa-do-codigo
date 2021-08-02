package br.com.zupacademy.yudi.casadocodigo.livro;

import br.com.zupacademy.yudi.casadocodigo.livro.dto.ListaLivroResponse;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroRequest;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager em;
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest request) {
        LivroEntity livro = request.toModel(em);
        livroRepository.save(livro);
        return ResponseEntity.ok(new NovoLivroResponse(livro));
    }

    @GetMapping
    public ResponseEntity<Page<ListaLivroResponse>> listar(Pageable paginacao) {
        Page<LivroEntity> livrosPaginados = livroRepository.findAll(paginacao);
        return ResponseEntity.ok(livrosPaginados.map(ListaLivroResponse::new));
    }
}
