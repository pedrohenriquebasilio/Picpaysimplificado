package com.example.Picpaybackend.infra;

import com.example.Picpaybackend.dtos.ExceptioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity DuplicateEntry(DataIntegrityViolationException exception){
        ExceptioDTO exceptionDTO = new ExceptioDTO("Usuario já cadastrado","400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity EntityNotFound(EntityNotFoundException exception){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity General(EntityNotFoundException exception){
        ExceptioDTO exceptionDTO = new ExceptioDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
