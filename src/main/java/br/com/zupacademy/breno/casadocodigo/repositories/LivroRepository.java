package br.com.zupacademy.breno.casadocodigo.repositories;

import br.com.zupacademy.breno.casadocodigo.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
