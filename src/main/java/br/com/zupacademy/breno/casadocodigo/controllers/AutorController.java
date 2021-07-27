package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Autor;
import br.com.zupacademy.breno.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping(value = "/autores")
    @Transactional
    public ResponseEntity<AutorDTO> cadastra(@RequestBody @Valid AutorDTO autorDTO) {
        Autor autor = autorDTO.toModel();
        repository.save(autor);
        return ResponseEntity.ok().build();
    }
}
