package br.com.zup.casadocodigo.book.bookconsultation;

import br.com.zup.casadocodigo.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookConsultationController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<BookSummaryDto> listAll() {
        List<BookSummaryDto> books = bookRepository.findAllBooks();
        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailResponseDto> getBookDetail(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return ResponseEntity.ok(new BookDetailResponseDto(book.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
