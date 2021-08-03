package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Categoria;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public CategoriaDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public CategoriaDTO() {
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return this.nome;
    }
}
