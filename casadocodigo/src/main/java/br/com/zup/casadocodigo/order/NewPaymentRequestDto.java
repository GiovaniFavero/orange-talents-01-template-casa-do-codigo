package br.com.zup.casadocodigo.order;

import br.com.zup.casadocodigo.countrystate.Country;
import br.com.zup.casadocodigo.countrystate.State;
import br.com.zup.casadocodigo.shared.config.validation.annotations.CPForCNPJ;
import br.com.zup.casadocodigo.shared.config.validation.annotations.ExistsId;
import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewPaymentRequestDto {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @CPForCNPJ
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;
    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long countryId;
    @NotNull
    @ExistsId(domainClass = State.class, fieldName = "id")
    private Long stateId;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String cep;

    public NewPaymentRequestDto(@NotBlank @Email String email, @NotBlank String name, @NotBlank String surname, @NotBlank String document, @NotBlank String address, @NotBlank String complement, @NotBlank String city, @NotNull Long countryId, @NotNull Long stateId, @NotBlank String phoneNumber, @NotBlank String cep) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phoneNumber = phoneNumber;
        this.cep = cep;
    }

    public String getDocument() {
        return this.document;
    }

    public boolean isValidDocument() {
        Assert.hasLength(this.document, "O documento deve ser preenchido!");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(this.document, null) || cnpjValidator.isValid(this.document, null);
    }

    public Long getCountryId() {
        return this.countryId;
    }

    public Long getStateId() {
        return stateId;
    }
}
