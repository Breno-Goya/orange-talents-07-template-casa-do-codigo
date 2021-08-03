package br.com.zupacademy.breno.casadocodigo.repositories;

import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisId(String nome, Long id);
    Optional<Estado> findByIdAndPaisId(Long id, Long paisId);
}
