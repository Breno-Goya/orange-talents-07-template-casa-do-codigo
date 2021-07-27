package br.com.zupacademy.breno.casadocodigo.repositories;

import br.com.zupacademy.breno.casadocodigo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
