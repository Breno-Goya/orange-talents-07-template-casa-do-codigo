package br.com.zupacademy.breno.casadocodigo.validations.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistIdValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ExistId {

    public String message() default "{br.com.zupacademy.breno.casadocodigo.beanvalidation.existId}";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default{};
    String fieldName();
    Class<?> domainClass();
}