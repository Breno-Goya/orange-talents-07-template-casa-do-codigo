package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.EstadoDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import br.com.zupacademy.breno.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrarEstado (@RequestBody @Valid EstadoDTO dto, UriComponentsBuilder uriComponentsBuilder) {

       Optional<Estado> possivelEstado = dto.toModel(paisRepository);
       if (possivelEstado.isPresent()) {
           Estado estado = repository.save(possivelEstado.get());
           URI uri = uriComponentsBuilder.path("/estados/{id}").buildAndExpand(possivelEstado.isPresent()).toUri();
           return ResponseEntity.created(uri).body(estado);
       }
       return ResponseEntity.badRequest().build();
    }
}

