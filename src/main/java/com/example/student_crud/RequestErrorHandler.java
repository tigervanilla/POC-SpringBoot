package com.example.student_crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RequestErrorHandler extends ResponseEntityExceptionHandler {

    public static class StudentServiceException extends RuntimeException {
        public StudentServiceException(String message) {
            super(message);
        }
    }

    public static class ServiceError {
        private String error;

        public ServiceError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    @ExceptionHandler(value = StudentServiceException.class)
    protected ResponseEntity<Object> handleServiceErrors(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(new ServiceError(ex.getMessage()));
    }
}
