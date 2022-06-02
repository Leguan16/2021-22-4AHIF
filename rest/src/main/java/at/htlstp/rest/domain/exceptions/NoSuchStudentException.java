package at.htlstp.rest.domain.exceptions;

import lombok.experimental.StandardException;

public class NoSuchStudentException extends RuntimeException {

    public NoSuchStudentException() {
        super("No such student");
    }

    public NoSuchStudentException(String message) {
        super(message);
    }
}
