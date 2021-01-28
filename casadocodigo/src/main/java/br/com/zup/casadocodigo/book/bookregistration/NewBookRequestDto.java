package br.com.zup.casadocodigo.book.bookregistration;

import br.com.zup.casadocodigo.shared.config.validation.annotations.UniqueValue;
import br.com.zup.casadocodigo.author.Author;
import br.com.zup.casadocodigo.book.Book;
import br.com.zup.casadocodigo.category.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class NewBookRequestDto {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;
    @NotBlank
    @Length(max = 500)
    private String report; //resumo
    private String summary; //sumário
    @Min(20)
    private BigDecimal price;
    @Min(100)
    private int numberOfPages;
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime publicationDate;
    @NotNull
    private Long categoryId;
    @NotNull
    private Long authorId;

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

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public Long getCategory() {
        return categoryId;
    }

    public Long getAuthor() {
        return authorId;
    }

    public Book toModel(EntityManager entityManager) {
        Author author = entityManager.find(Author.class, this.authorId);
        Category category = entityManager.find(Category.class, this.categoryId);
        Assert.state(author!=null, "O autor não existe!");
        Assert.state(category!=null, "A categoria não existe!");

        return new Book(this.title, this.report, this.summary, this.price, this.numberOfPages, this.isbn, this.publicationDate, category, author);
    }
}
