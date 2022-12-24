package br.com.banco.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class TransferenciaExceptionHandler {

    @ExceptionHandler(value = {TransferenciaNotFoundException.class})
    public ResponseEntity<GlobalError> transferenciaNotFoundException(TransferenciaNotFoundException ex,
                                                                   WebRequest request) {
        GlobalError message = new GlobalError(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DateTimeParseException.class})
    public ResponseEntity<GlobalError> dateTimeParseException(DateTimeParseException ex,
                                                                   WebRequest request) {
        GlobalError message = new GlobalError(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<GlobalError> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex,
                                                              WebRequest request) {
        GlobalError message = new GlobalError(ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
