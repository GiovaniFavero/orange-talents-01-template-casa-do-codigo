package br.com.zup.casadocodigo.book.bookregistration;

import br.com.zup.casadocodigo.book.Book;
import br.com.zup.casadocodigo.book.bookconsultation.AuthorDetailResponseDto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class BookResponseDto {

    private String title;
    private String report; //resumo
    private String summary; //sumário
    private BigDecimal price;
    private int numberOfPages;
    private String isbn;
    private String publicationDate;
    private AuthorDetailResponseDto author;
    private CategoryDetailDto category;

    public BookResponseDto(Book book) {
        this.title = book.getTitle();
        this.report = book.getReport();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.author = new AuthorDetailResponseDto(book.getAuthor());
        this.publicationDate = book.getPublicationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.category = new CategoryDetailDto(book.getCategory());
    }

    public String getTitle() {
        return title;
    }

    public String getReport() {
        return report;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public AuthorDetailResponseDto getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public CategoryDetailDto getCategory() {
        return category;
    }
}
