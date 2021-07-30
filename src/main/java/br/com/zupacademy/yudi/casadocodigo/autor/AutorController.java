package br.com.zupacademy.yudi.casadocodigo.autor;

import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorRequest;
import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator;
    private final AutorRepository autorRepository;

    public AutorController(ProibeEmailDuplicadoAutorValidator proibeEmailDuplicadoAutorValidator, AutorRepository autorRepository) {
        this.proibeEmailDuplicadoAutorValidator = proibeEmailDuplicadoAutorValidator;
        this.autorRepository = autorRepository;
    }

    @InitBinder
    public void initBinders(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<NovoAutorResponse> cadastrar(@RequestBody @Valid NovoAutorRequest request) {
        AutorEntity autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok(new NovoAutorResponse(autor));
    }
}
