package br.com.zupacademy.yudi.casadocodigo.autor;

import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEmailDuplicadoAutorValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoAutorRequest request) {
        AutorEntity autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok().build();
    }
}
