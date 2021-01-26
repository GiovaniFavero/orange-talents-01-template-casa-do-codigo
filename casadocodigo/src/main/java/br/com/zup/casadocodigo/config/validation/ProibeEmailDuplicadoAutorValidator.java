package br.com.zup.casadocodigo.config.validation;

import br.com.zup.casadocodigo.controller.dto.NovoAutorRequest;
import br.com.zup.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NovoAutorRequest novoAutorRequest = (NovoAutorRequest) target;
        if(autorRepository.countByEmail(novoAutorRequest.getEmail()) > 0) {
            errors.rejectValue("email", null, "O e-mail " + novoAutorRequest.getEmail() + " já está cadastrado para outro autor!");
        }
    }
}
