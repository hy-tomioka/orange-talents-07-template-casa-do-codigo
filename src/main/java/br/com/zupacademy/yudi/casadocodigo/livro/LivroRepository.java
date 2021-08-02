package br.com.zupacademy.yudi.casadocodigo.livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
