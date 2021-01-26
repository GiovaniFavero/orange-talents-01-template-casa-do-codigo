package br.com.zup.casadocodigo.repository;

import br.com.zup.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    long countByEmail(String email);

}
