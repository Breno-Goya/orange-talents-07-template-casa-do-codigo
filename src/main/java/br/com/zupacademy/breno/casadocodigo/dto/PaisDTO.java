package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Pais;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisDTO {

    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }

}
