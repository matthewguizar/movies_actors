package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<Movie>();


    public Actor() {
    }

    public Actor(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies(){return movies;}

    //making inverse end also responsible for the relationship
    public void addMovie(Movie movie){
        this.movies.add(movie);
        movie.getActors().add(this);
    }

    public void removeMovie(Movie movie){
        this.movies.remove(movie);
        movie.getActors().remove(this);
    }
}
