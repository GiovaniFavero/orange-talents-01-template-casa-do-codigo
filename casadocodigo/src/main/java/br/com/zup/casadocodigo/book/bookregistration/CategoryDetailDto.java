package br.com.zup.casadocodigo.book.bookregistration;

import br.com.zup.casadocodigo.category.Category;

public class CategoryDetailDto {

    private String name;

    public String getName() {
        return name;
    }

    public CategoryDetailDto(Category category) {
        this.name = category.getName();
    }
}
