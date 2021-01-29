package br.com.zup.casadocodigo.category;

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
@RequestMapping("/api/categories")
public class CategoryRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryResponseDto> create(@RequestBody @Valid NewCategoryRequestDto newCategory) {
        Category category = newCategory.toModel();
        entityManager.persist(category);
        return ResponseEntity.ok(new CategoryResponseDto(category));
    }

}
