package com.example.projetoCityDenuncia.infra;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<String> dataIntegrityViolationHandler(DataIntegrityViolationException exception) {
        String specificMsg = exception.getMostSpecificCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Causa: " + specificMsg);
    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Map<String, String>> runtimeHandler(RuntimeException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("mensage", exception.getMessage());
        response.put("local", exception.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(JWTCreationException.class)
    private ResponseEntity<String> jwtCreationHandler(JWTCreationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro durante a geração do token");
    }

    @ExceptionHandler(JWTVerificationException.class)
    private ResponseEntity<String> jwtVerificationHandler(JWTVerificationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro durante a válidação do token");
    }

}
