package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@ToString

@Entity
public class Director {

    @Id
    @Getter
    @Setter
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "director")    //Name der Variable auf der Owning-Seite
    private List<Movie> movies = new ArrayList<>();

    public Director(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return List.copyOf(movies);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
        movie.setDirector(this);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
        movie.setDirector(null);
    }
}
