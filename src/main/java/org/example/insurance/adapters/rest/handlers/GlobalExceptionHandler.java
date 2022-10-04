package org.example.insurance.adapters.rest.handlers;

import org.example.insurance.domain.exceptions.DomainException;
import org.example.insurance.domain.exceptions.EntityExistedException;
import org.example.insurance.domain.exceptions.EntityNotFoundException;
import org.example.insurance.domain.exceptions.NoNeedToPublishException;
import com.google.common.collect.ImmutableMap;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return handleDomainException(ex, NOT_FOUND);
    }

    @ExceptionHandler({EntityExistedException.class})
    public ResponseEntity<Object> handleEntityExistedException(EntityExistedException ex) {
        return handleDomainException(ex, CONFLICT);
    }

    @ExceptionHandler({NoNeedToPublishException.class})
    public ResponseEntity<Object> handleNoNeedToPublishException(NoNeedToPublishException ex) {
        return handleDomainException(ex, CONFLICT);
    }

    private ResponseEntity<Object> handleDomainException(DomainException ex, HttpStatus conflict) {
        return new ResponseEntity<>(ImmutableMap.of("message", ex.getMessage()), new HttpHeaders(), conflict);
    }
}
