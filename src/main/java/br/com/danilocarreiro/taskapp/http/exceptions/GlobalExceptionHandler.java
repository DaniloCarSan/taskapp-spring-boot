package br.com.danilocarreiro.taskapp.http.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.danilocarreiro.taskapp.business.domain.exceptions.OrganizationAlreadyExistsException;
import br.com.danilocarreiro.taskapp.business.domain.exceptions.OrganizationNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizationAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleException(OrganizationAlreadyExistsException e) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problemDetail.setTitle("Organization already exists");
        problemDetail.setDetail(e.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleException(OrganizationNotFoundException e) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("Organization not found");
        problemDetail.setDetail(e.getMessage());
        return ResponseEntity.badRequest().body(problemDetail);
    }

}
