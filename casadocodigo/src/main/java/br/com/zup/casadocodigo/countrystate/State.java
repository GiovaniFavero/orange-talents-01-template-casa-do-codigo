package br.com.zup.casadocodigo.countrystate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    public State(@NotBlank String name, @NotNull Country country) {
        this.name = name;
        this.country = country;
    }

    @Deprecated
    public State(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return name.equals(state.name) && country.equals(state.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }

    public boolean belongsToCountry(Country country) {
        return this.country.equals(country);
    }

    public Long getId() {
        return id;
    }
}
