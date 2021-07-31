package br.com.zupacademy.breno.casadocodigo.response;

import br.com.zupacademy.breno.casadocodigo.entities.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroResponseDetalhes {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private AutorResponse autor;

    public LivroResponseDetalhes(Livro entidade) {
        this.id = entidade.getId();
        this.titulo = entidade.getTitulo();
        this.resumo = entidade.getResumo();
        this.sumario = entidade.getSumario();
        this.preco = entidade.getPreco();
        this.numeroPaginas = entidade.getNumeroPaginas();
        this.isbn = entidade.getIsbn();
        this.dataPublicacao = entidade.getDataPublicacao();
        this.autor = new AutorResponse(entidade.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorResponse getAutor() {
        return autor;
    }
}
