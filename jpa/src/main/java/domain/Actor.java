package domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter

@Entity
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;

    public Actor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @ManyToMany
    private List<Movie> movies;
}
