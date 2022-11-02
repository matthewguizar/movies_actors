package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
        name="movie_actor",
        joinColumns={@JoinColumn(name="movie_id")},
        inverseJoinColumns={@JoinColumn(name="actor_id")}
    )
    private Set<Actor> actors = new HashSet<>();


    public Movie() {
    }

    public Movie(String name) {
        this.name = name;
    }

    public Set<Actor> getActors(){return actors;}

}
