package at.htlstp.rest.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "students")

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    private int number;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "school")
    private School school;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
