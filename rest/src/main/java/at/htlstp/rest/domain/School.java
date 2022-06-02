package at.htlstp.rest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schools")

//TODO getter/setter selber schreiben
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Student> students;
}
