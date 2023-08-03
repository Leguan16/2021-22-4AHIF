package at.htlstp.rest.persistence;

import at.htlstp.rest.domain.Student;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public record DatabaseInitializer(StudentRepository studentRepository) implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("After all init");
        //List.of(
        //        new Student(null, "Spilka", 16),
        //        new Student(null, "Mauss", 7),
        //        new Student(null, "Metzler", 9)
        //).forEach(studentRepository::save);
    }
}
