package br.com.zupacademy.breno.casadocodigo.controllers;

import br.com.zupacademy.breno.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Autor;
import br.com.zupacademy.breno.casadocodigo.entities.Categoria;
import br.com.zupacademy.breno.casadocodigo.entities.Livro;
import br.com.zupacademy.breno.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.LivroRepository;
import br.com.zupacademy.breno.casadocodigo.response.LivroResponse;
import br.com.zupacademy.breno.casadocodigo.response.LivroResponseDetalhes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastro(@RequestBody @Valid LivroDTO dto, UriComponentsBuilder uriComponentsBuilder) {

        Optional<Autor> possivelAutor = autorRepository.findById(dto.getIdAutor());
        Optional<Categoria> possivelCategoria = categoriaRepository.findById(dto.getIdCategoria());

        if(possivelAutor.isEmpty()){
            return new ResponseEntity<>("Não pode cadastrar um livro sem autor", HttpStatus.BAD_REQUEST);
        }
        if (possivelCategoria.isEmpty()) {
            return new ResponseEntity<>("Não pode cadastrar um livro sem categoria", HttpStatus.BAD_REQUEST);
        }

        Autor autor = possivelAutor.get();
        Categoria categoria = possivelCategoria.get();
        Livro livro = dto.toModel(autor, categoria);
        URI uri = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(livro.getId()).toUri();

        livroRepository.save(livro);

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> livros() {
        List<Livro> livros = livroRepository.findAll();
        List<LivroResponse> listaLivros = LivroResponse.converter(livros);
        return ResponseEntity.ok().body(listaLivros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDetalhes> buscaLivroId(@PathVariable Long id) {
        Optional<Livro> livroObj = livroRepository.findById(id);
        if (livroObj.isPresent()) {
            Livro livro = livroObj.get();
            return ResponseEntity.ok().body(new LivroResponseDetalhes(livro));
        }
        return ResponseEntity.notFound().build();
    }
}
