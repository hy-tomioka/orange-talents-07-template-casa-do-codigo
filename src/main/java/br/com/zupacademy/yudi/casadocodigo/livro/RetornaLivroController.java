package br.com.zupacademy.yudi.casadocodigo.livro;

import br.com.zupacademy.yudi.casadocodigo.livro.dto.DetalharLivroResponse;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.ListaLivroResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class RetornaLivroController {

    private final LivroRepository livroRepository;

    public RetornaLivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public ResponseEntity<Page<ListaLivroResponse>> listar(Pageable paginacao) {
        Page<LivroEntity> livrosPaginados = livroRepository.findAll(paginacao);
        return ResponseEntity.ok(livrosPaginados.map(ListaLivroResponse::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalharLivroResponse> detalhar(@PathVariable Long id) {
        Optional<LivroEntity> livro = livroRepository.findById(id);
        if (livro.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new DetalharLivroResponse(livro.get()));
    }
}
