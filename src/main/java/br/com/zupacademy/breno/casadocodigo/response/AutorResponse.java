package br.com.zupacademy.breno.casadocodigo.response;

import br.com.zupacademy.breno.casadocodigo.entities.Autor;

public class AutorResponse {

    private Long id;
    private String nome;
    private String descricao;

    public AutorResponse(Autor entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.descricao = entidade.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
