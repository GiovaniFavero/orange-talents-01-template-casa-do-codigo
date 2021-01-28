package br.com.zup.casadocodigo.shared.config.validation.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CPF(message = "Necessário informar um CPF ou CNPJ válido!")
@CNPJ(message = "Necessário informar um CPF ou CNPJ válido!")
@ConstraintComposition(CompositionType.OR)
public @interface CPForCNPJ {

    String message() default "Necessário preecher um CPF ou CNPJ válido!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
