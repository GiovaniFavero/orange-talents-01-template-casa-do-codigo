package br.com.zup.casadocodigo.book.bookconsultation;

public class BookSummaryDto {

    private Long id;
    private String title;

    public BookSummaryDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
