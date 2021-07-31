package br.com.zupacademy.breno.casadocodigo.response;

import br.com.zupacademy.breno.casadocodigo.entities.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroResponse {

    private Long id;
    private String nome;

    public LivroResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static List<LivroResponse> converter(List<Livro> livros) {
        List<LivroResponse> listaLivros = new ArrayList<>();
        listaLivros.addAll(livros.stream().map(livro -> new LivroResponse(livro.getId(), livro.getTitulo())).collect(Collectors.toList()));
        return listaLivros;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
