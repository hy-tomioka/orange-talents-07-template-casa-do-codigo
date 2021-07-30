package br.com.zupacademy.yudi.casadocodigo.cadastro;

import br.com.zupacademy.yudi.casadocodigo.cadastro.dto.NovaCategoriaRequest;
import br.com.zupacademy.yudi.casadocodigo.cadastro.dto.NovaCategoriaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;
    private final ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicadaValidator;

    public CategoriaController(CategoriaRepository categoriaRepository,
                               ProibeCategoriaDuplicadaValidator proibeCategoriaDuplicadaValidator) {
        this.categoriaRepository = categoriaRepository;
        this.proibeCategoriaDuplicadaValidator = proibeCategoriaDuplicadaValidator;
    }

    @InitBinder
    public void initBinders(WebDataBinder binder) {
        binder.addValidators(proibeCategoriaDuplicadaValidator);
    }

    @PostMapping
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest request) {
        CategoriaEntity categoria = request.toModel();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok(new NovaCategoriaResponse(categoria));
    }
}
