package br.com.zup.casadocodigo.author;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public AuthorResponseDto create(@RequestBody @Valid NewAuthorRequestDto newAuthor) {
        Author author = newAuthor.toModel();
        entityManager.persist(author);
        return new AuthorResponseDto(author);
    }
}
