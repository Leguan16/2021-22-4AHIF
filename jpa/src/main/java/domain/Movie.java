package domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Short id;

    private String name;

    @ManyToOne
    private Director director;
}
