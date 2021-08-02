package br.com.zupacademy.yudi.casadocodigo.livro;

import br.com.zupacademy.yudi.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.yudi.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroRequest;
import br.com.zupacademy.yudi.casadocodigo.livro.dto.NovoLivroResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;
    private final LivroRepository livroRepository;

    public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository,
                           LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest request) {
        LivroEntity livro = request.toModel(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok(new NovoLivroResponse(livro));
    }
}
