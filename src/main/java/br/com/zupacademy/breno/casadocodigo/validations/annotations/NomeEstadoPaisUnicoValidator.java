package br.com.zupacademy.breno.casadocodigo.validations.annotations;

import br.com.zupacademy.breno.casadocodigo.dto.EstadoDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import br.com.zupacademy.breno.casadocodigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class NomeEstadoPaisUnicoValidator implements ConstraintValidator<NomeEstadoPaisUnico, EstadoDTO> {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(EstadoDTO value, ConstraintValidatorContext context) {

        Optional<Estado> estadoObj = estadoRepository.findByNomeAndPaisId(value.getNome(), value.getPaisId());
        if(estadoObj.isPresent()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Já existe Estado cadastrado")
                    .addPropertyNode("nome")
                    .addConstraintViolation();
        }
        return estadoObj.isEmpty();
    }
}
