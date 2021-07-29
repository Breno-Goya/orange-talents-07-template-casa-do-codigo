package br.com.zupacademy.breno.casadocodigo.validations;

import br.com.zupacademy.breno.casadocodigo.dto.AutorDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Autor;
import br.com.zupacademy.breno.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        AutorDTO autorDTO = (AutorDTO) o;
        Optional<Autor> possivelAutor = repository.findByEmail(autorDTO.getEmail());

        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null, "Email já cadastrado " + autorDTO.getEmail());
        }
    }
}
