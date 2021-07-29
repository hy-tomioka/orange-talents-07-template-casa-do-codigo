package br.com.zupacademy.yudi.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<AutorEntity, Long> {
    Optional<AutorEntity> findByEmail(String email);
}
