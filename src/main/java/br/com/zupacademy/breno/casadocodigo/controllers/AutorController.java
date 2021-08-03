package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Autor;
import br.com.zupacademy.breno.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.breno.casadocodigo.validations.EmailDuplicadoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private EmailDuplicadoAutorValidator emailDuplacadoAutorValidator;

    @InitBinder
    public void init(WebDataBinder binder)  {
        binder.addValidators(emailDuplacadoAutorValidator);
    }

    @PostMapping(value = "/autores")
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid AutorDTO dto, UriComponentsBuilder uriComponentsBuilder) {

        Autor autor = dto.toModel();
        repository.save(autor);
        URI uri = uriComponentsBuilder.path("autores/{id}").buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(uri).body(autor);
    }
}
