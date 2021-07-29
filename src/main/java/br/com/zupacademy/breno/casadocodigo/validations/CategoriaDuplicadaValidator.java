package br.com.zupacademy.breno.casadocodigo.validations;

import br.com.zupacademy.breno.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Categoria;
import br.com.zupacademy.breno.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaDuplicadaValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        CategoriaDTO categoriaDTO = (CategoriaDTO) o;
        Optional<Categoria> possivelCategoria = repository.findByNome(categoriaDTO.getNome());

        if(possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Categoria já cadastrada " + categoriaDTO.getNome());
        }
    }
}
