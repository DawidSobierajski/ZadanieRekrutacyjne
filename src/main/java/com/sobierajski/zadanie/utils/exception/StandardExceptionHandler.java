package com.sobierajski.zadanie.utils.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Slf4j
public class StandardExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity handle(ElementNotFoundException e) {
        log.info(e.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ElementExistsException.class)
    public ResponseEntity handle(ElementExistsException e) {
        log.info(e.getMessage());
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(RunScriptException.class)
    public ResponseEntity handle(RunScriptException e){
        log.error(e.getMessage(),e);
        return new ResponseEntity(INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handle(Exception e) {
        log.error(e.getLocalizedMessage(), e);
        return new ResponseEntity(INTERNAL_SERVER_ERROR);
    }
}
