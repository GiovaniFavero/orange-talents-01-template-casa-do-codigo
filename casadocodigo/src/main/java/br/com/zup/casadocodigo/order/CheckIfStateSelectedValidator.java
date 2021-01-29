package br.com.zup.casadocodigo.order;

import br.com.zup.casadocodigo.countrystate.Country;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CheckIfStateSelectedValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

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
        Long idCountry = request.getCountryId();
        Country country = entityManager.find(Country.class, idCountry);
        if(country.hasStates(entityManager) && (request.getStateId() == null || request.getStateId() == 0)) {
            errors.rejectValue("stateId", null, "O pais preenchido possui estados cadastrados, portanto o estado deve ser preenchido!");
        }
    }
}
