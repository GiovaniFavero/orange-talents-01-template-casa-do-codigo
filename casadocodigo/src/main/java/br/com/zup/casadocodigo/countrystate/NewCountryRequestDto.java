package br.com.zup.casadocodigo.countrystate;

import br.com.zup.casadocodigo.shared.config.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Country toModel() {
        return new Country(this.name);
    }
}
