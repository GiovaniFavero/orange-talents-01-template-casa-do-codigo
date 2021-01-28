package br.com.zup.casadocodigo.shared.config.validation;

import br.com.zup.casadocodigo.countrystate.Country;
import br.com.zup.casadocodigo.countrystate.State;
import br.com.zup.casadocodigo.order.NewPaymentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateBelongsToCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPaymentRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        NewPaymentRequestDto request = (NewPaymentRequestDto) target;
        Country country = entityManager.find(Country.class, request.getCountryId());
        State state = entityManager.find(State.class, request.getStateId());
        if(!state.belongsToCountry(country)) {
            errors.rejectValue("stateId", null, "O estado não pertence a este país!");
        }
    }
}
