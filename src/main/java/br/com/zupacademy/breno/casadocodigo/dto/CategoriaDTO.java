package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Categoria;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Categoria.class)

    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }
}
