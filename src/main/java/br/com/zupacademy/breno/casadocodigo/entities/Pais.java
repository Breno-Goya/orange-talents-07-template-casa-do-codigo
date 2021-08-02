package br.com.zupacademy.breno.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private Set<Estado> estados;

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
        this.estados = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
