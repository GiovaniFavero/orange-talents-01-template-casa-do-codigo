package br.com.zup.casadocodigo.category;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public CategoryResponseDto create(@RequestBody @Valid NewCategoryRequest newCategory) {
        Category category = newCategory.toModel();
        entityManager.persist(category);
        return new CategoryResponseDto(category);
    }

}
