package br.com.zup.casadocodigo.author;

import br.com.zup.casadocodigo.shared.config.validation.annotations.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewAuthorRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;
    @Length(max = 400)
    @NotBlank
    private String description;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel() {
        return new Author(this.name, this.email, this.description);
    }
}
