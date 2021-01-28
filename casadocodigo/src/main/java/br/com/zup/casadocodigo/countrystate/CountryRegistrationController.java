package br.com.zup.casadocodigo.countrystate;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class CountryRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity create (@RequestBody @Valid NewCountryRequestDto request, UriComponentsBuilder uriBuilder) {
        Country country = request.toModel();
        entityManager.persist(country);
        URI location = uriBuilder.path("/paises/{id}")
                            .buildAndExpand(country.getId())
                            .toUri();
        return ResponseEntity.created(location).build();
    }
}
