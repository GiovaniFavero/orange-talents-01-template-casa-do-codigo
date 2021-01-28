package br.com.zup.casadocodigo.book.bookregistration;

import br.com.zup.casadocodigo.book.Book;
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
@RequestMapping("/livros")
public class BookRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public BookResponseDto create(@RequestBody @Valid NewBookRequestDto newBookRequestDto) {
        Book book = newBookRequestDto.toModel(entityManager);
        return new BookResponseDto(book);
    }
}
