package br.com.zup.casadocodigo.countrystate;

import br.com.zup.casadocodigo.shared.config.validation.annotations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewStateRequestDto {

    @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name")
    private String name;
    @NotNull
    private Long countryId;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, this.countryId);
        return new State(this.name, country);
    }
}
