package br.com.zup.casadocodigo.book.bookconsultation;

import br.com.zup.casadocodigo.book.Book;
import br.com.zup.casadocodigo.book.bookconsultation.BookSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select new br.com.zup.casadocodigo.book.bookconsultation.BookSummaryDto(b.id, b.title) from Book b", nativeQuery = false)
    List<BookSummaryDto> findAllBooks();
}
