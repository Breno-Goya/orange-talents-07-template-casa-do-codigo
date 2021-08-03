package br.com.zupacademy.breno.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Deprecated
    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
        this.estados = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void addEstado(Estado estado) {
        this.estados.add(estado);
    }

    public boolean temEstados() {
        return !estados.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(id, pais.id) && nome.equals(pais.nome) && Objects.equals(estados, pais.estados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estados);
    }
}
