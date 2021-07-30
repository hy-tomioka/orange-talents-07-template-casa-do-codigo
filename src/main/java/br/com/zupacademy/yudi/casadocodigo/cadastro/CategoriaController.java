package br.com.zupacademy.yudi.casadocodigo.cadastro;

import br.com.zupacademy.yudi.casadocodigo.cadastro.dto.NovaCategoriaRequest;
import br.com.zupacademy.yudi.casadocodigo.cadastro.dto.NovaCategoriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
        CategoriaEntity categoria = request.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
    }
}
