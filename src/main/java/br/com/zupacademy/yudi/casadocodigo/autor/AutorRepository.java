package br.com.zupacademy.yudi.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    Optional<AutorEntity> findByEmail(String email);
}
