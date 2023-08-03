package at.htlstp.rest.persistence;

import at.htlstp.rest.domain.School;
import at.htlstp.rest.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    long countAllByNameContainingIgnoreCase(String name);

    List<Student> findAllByNameContaining(String name);

    @Query("""
            select student
            from Student student
            where student.school.title = ?1""")
    List<Student> findAllBySchool(String school);
}
