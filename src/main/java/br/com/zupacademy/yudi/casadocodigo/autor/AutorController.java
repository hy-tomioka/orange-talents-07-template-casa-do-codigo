package br.com.zupacademy.yudi.casadocodigo.autor;

import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorRequest;
import br.com.zupacademy.yudi.casadocodigo.autor.dto.NovoAutorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public ResponseEntity<NovoAutorResponse> cadastrar(@RequestBody @Valid NovoAutorRequest request) {
        AutorEntity autor = request.toModel();
        autorRepository.save(autor);
        return ResponseEntity.ok(new NovoAutorResponse(autor));
    }
}
