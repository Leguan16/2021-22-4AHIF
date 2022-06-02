package at.htlstp.rest.presentation;

import at.htlstp.rest.domain.Student;
import at.htlstp.rest.domain.exceptions.NoSuchStudentException;
import at.htlstp.rest.persistence.StudentRepository;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/students")
public record StudentController(StudentRepository studentRepository) {

    //@GetMapping
    //public List<Student> all() {
    //    return studentRepository.findAll();
    //}

    @GetMapping
    public List<Student> bySchool(@RequestParam(required = false) String school) {
        if (school == null)
            return studentRepository.findAll();

        return studentRepository
                .findAll()
                .stream()
                .filter(student -> student.getSchool().getTitle().equals(school))
                .toList();

    }

    @GetMapping("{id}")
    public Student one(@PathVariable Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(NoSuchStudentException::new);
        //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody @Valid Student student) {
        var saved = studentRepository.save(student);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(saved.getId());
        return ResponseEntity
                .created(uri)
                .body(saved);
    }
}
