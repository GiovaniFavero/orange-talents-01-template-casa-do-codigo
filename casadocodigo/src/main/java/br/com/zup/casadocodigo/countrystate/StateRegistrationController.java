package br.com.zup.casadocodigo.countrystate;

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
@RequestMapping("/states")
public class StateRegistrationController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid NewStateRequestDto request) {
        State state = request.toModel(entityManager);
        entityManager.persist(state);
        return ResponseEntity.ok().build();
    }

}
