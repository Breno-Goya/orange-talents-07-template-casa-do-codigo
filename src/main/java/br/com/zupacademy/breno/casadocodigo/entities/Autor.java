package br.com.zupacademy.breno.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank @Email @Column(unique = true)
    private String email;

    @NotBlank @Size(max = 400)
    private String descricao;

    private Instant momento = Instant.now();

    public Autor() {}

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank() @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
