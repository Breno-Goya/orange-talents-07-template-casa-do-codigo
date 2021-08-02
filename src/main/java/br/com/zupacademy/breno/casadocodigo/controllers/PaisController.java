package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.PaisDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Pais;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {

    private PaisRepository repository;

    public PaisController(PaisRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastraPais (@RequestBody @Valid PaisDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        Pais pais = dto.toModel();
        repository.save(pais);
        URI uri = uriComponentsBuilder.path("paises/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
