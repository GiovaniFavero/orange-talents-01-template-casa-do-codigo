package br.com.zup.casadocodigo.author;

import java.time.LocalDateTime;

public class AuthorResponseDto {

    private Long id;
    private String name;
    private String email;
    private String description;
    private LocalDateTime creationDate;

    public AuthorResponseDto(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.creationDate = author.getCreationDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
