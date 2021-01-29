package br.com.zup.casadocodigo.order;

import br.com.zup.casadocodigo.order.NewPaymentRequestDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CheckCpfCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPaymentRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        NewPaymentRequestDto request = (NewPaymentRequestDto) target;
        String document = request.getDocument();
        if(!request.isValidDocument()) {
            errors.rejectValue("document", null, "Documento precisa ser um CPF ou CNPJ válido!");
        }
    }
}
