package br.com.zupacademy.breno.casadocodigo.validations.annotations;

import br.com.zupacademy.breno.casadocodigo.dto.ClienteDTO;
import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import br.com.zupacademy.breno.casadocodigo.entities.Pais;
import br.com.zupacademy.breno.casadocodigo.exceptions.CampoMensagemError;
import br.com.zupacademy.breno.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteEstadoPaisValidator  implements ConstraintValidator<ClienteEstadoPais, ClienteDTO> {

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public boolean isValid(ClienteDTO value, ConstraintValidatorContext context) {
       List<CampoMensagemError> errors = new ArrayList<>();

       Optional<Pais> paisObjeto = paisRepository.findById(value.getPaisId());

       if(paisObjeto.isPresent()) {
           Pais pais = paisObjeto.get();

           if(pais.temEstados()) {
               if (value.getEstadoId() == null) {
                   errors.add(new CampoMensagemError("estadoId", "Informar um estado para o país selecionado"));
               } else {
                   Optional<Estado> estadoObjeto = estadoRepository.findByIdAndPaisId(value.getEstadoId(), value.getPaisId());
                   if(estadoObjeto.isEmpty())
                       errors.add(new CampoMensagemError("estadoID", "Informar estado válido para o país escolhido"));
               }
           }
       } else {
           errors.add(new CampoMensagemError("paisId","País com o id não encontrado"));
       }
      addErrorsNoContextoValidacao(errors, context);

       return errors.isEmpty();
    }

    private void addErrorsNoContextoValidacao(List<CampoMensagemError> erros, ConstraintValidatorContext context) {
        for(CampoMensagemError e : erros) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMensagem()).addPropertyNode(e.getNomeCampo()).addConstraintViolation();
        }
    }
}
