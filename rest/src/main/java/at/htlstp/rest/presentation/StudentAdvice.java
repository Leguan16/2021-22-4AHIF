package at.htlstp.rest.presentation;

import at.htlstp.rest.domain.exceptions.NoSuchStudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class StudentAdvice {

    @ExceptionHandler(NoSuchStudentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNoSuchElementException(NoSuchStudentException exception) {
        return new ApiError(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleInvalidArguments(MethodArgumentNotValidException exception) {
        return new ApiError(exception.getMessage());
    }
}
