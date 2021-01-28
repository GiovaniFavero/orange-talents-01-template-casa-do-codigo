package br.com.zup.casadocodigo.book.bookconsultation;

import br.com.zup.casadocodigo.author.Author;

public class AuthorDetailResponseDto {

    private String name;
    private String description;

    public AuthorDetailResponseDto(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
