package br.com.zup.casadocodigo.countrystate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    public Country(@NotBlank String name) {
        this.name = name;
    }

    @Deprecated
    public Country(){
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean hasStates(EntityManager entityManager){
        Query query = entityManager.createQuery("select 1 from State s join s.country as c where c.id = :value");
        query.setParameter("value", this.id);
        List<?> list = query.getResultList();
        return !list.isEmpty();
    }
}
