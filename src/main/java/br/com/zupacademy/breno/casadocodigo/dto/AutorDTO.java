package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {

    @NotBlank
    private String nome;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(max = 400)
    private String descricao;

    public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }


}
