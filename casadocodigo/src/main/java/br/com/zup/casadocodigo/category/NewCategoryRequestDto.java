package br.com.zup.casadocodigo.category;

import br.com.zup.casadocodigo.shared.config.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
