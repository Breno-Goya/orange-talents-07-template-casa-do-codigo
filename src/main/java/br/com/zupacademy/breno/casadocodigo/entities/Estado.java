package br.com.zupacademy.breno.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }
}
