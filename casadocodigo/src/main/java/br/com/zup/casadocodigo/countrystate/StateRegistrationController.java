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
@RequestMapping("/api/states")
public class StateRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewStateRequestDto request, UriComponentsBuilder uriBuilder) {
        State state = request.toModel(entityManager);
        entityManager.persist(state);
        URI location = uriBuilder.path("/api/states/{id}")
                .buildAndExpand(state.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
