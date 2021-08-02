package br.com.zupacademy.breno.casadocodigo.validations.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NomeEstadoPaisUnicoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface NomeEstadoPaisUnico {

    String message() default "Nome de Estado já cadastrado para esse País";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
