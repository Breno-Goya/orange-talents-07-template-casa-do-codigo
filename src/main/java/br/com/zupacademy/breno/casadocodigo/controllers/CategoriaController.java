package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Categoria;
import br.com.zupacademy.breno.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.breno.casadocodigo.validations.CategoriaDuplicadaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private CategoriaDuplicadaValidator categoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(categoriaDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid CategoriaDTO dto, UriComponentsBuilder uriComponentsBuilder) {

        Categoria categoria = dto.toModel();
        URI uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        repository.save(categoria);
        return ResponseEntity.created(uri).body(categoria);
    }
}
