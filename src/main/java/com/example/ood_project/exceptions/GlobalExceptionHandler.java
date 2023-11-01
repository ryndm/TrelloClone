package com.example.ood_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            response.addValidationError(fieldName, errorMessage);
        });
        return response;
    }

    // Catch all errors here
    @ExceptionHandler({RuntimeException.class, NotFoundException.class})
    @ResponseBody
    public ResponseEntity<String> handleInternalServerError(Exception ex) {
        ex.printStackTrace();
        HttpStatus status = (ex instanceof RuntimeException) ? HttpStatus.INTERNAL_SERVER_ERROR :
                (ex instanceof NotFoundException) ? HttpStatus.NOT_FOUND :
                HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(ex.getMessage(), status);
    }
}

class ValidationErrorResponse {
    private Map<String, String> validationErrors = new HashMap<>();

    public void addValidationError(String fieldName, String errorMessage) {
        validationErrors.put(fieldName, errorMessage);
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }
}
