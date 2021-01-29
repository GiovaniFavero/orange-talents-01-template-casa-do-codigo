package br.com.zup.casadocodigo.author;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorResponseDto> create(@RequestBody @Valid NewAuthorRequestDto newAuthor) {
        Author author = newAuthor.toModel();
        entityManager.persist(author);
        return ResponseEntity.ok(new AuthorResponseDto(author));
    }
}
