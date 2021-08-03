package br.com.zupacademy.breno.casadocodigo.repositories;

import br.com.zupacademy.breno.casadocodigo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
