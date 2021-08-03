package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.ClienteDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Cliente;
import br.com.zupacademy.breno.casadocodigo.repositories.ClienteRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.breno.casadocodigo.response.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/clientes")
public class ClienteControler {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> cadastra(@RequestBody @Valid ClienteDTO dto, UriComponentsBuilder uriComponentsBuilder) {
        Cliente cliente = dto.toModel(paisRepository, estadoRepository);
        clienteRepository.save(cliente);
        URI uri = uriComponentsBuilder.path("clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new ClienteResponse(cliente.getId()));
    }
}
