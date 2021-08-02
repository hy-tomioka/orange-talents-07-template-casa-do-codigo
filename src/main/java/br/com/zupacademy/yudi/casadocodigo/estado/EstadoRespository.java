package br.com.zupacademy.yudi.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRespository extends JpaRepository<EstadoEntity, Long> {

    List<EstadoEntity> findByNomeAndPaisId(String nome, Long paisId);
}
