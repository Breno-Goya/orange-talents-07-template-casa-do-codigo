package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import br.com.zupacademy.breno.casadocodigo.entities.Pais;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Long paisId;

    public EstadoDTO(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Optional<Estado> toModel(PaisRepository paisRepository) {
        Optional<Pais> objPais = paisRepository.findById(paisId);
        if (objPais.isPresent()) {
            Pais pais = objPais.get();
            Estado estado = new Estado(nome, pais);
            return Optional.of(estado);
        }
        return Optional.empty();
    }
}
