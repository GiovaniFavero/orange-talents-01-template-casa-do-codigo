package br.com.zup.casadocodigo.controller.dto;

import br.com.zup.casadocodigo.model.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @Length(max = 400)
    @NotBlank
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
