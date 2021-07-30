package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank(message = "Campo obrigatório")
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
