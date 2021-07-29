package br.com.zupacademy.breno.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
