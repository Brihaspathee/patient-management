package com.brihaspathee.patient.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/6/25
 * Time: 11:39 AM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.exception
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles MethodArgumentNotValidException thrown during validation errors in the application.
     * Captures validation errors and maps them to a response containing field names and corresponding error messages.
     *
     * @param ex the MethodArgumentNotValidException containing validation error details
     * @return a ResponseEntity containing a map of field names to their respective validation error messages and a bad request status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(java.util.stream.Collectors.toMap(
                        FieldError::getField,
                        DefaultMessageSourceResolvable::getDefaultMessage));
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles the EmailAlreadyExistsException thrown when attempting to use an already registered email address.
     * Logs the exception message and returns a response entity containing an appropriate error message.
     *
     * @param ex the EmailAlreadyExistsException containing details about the email conflict
     * @return a ResponseEntity containing a map with an error message and a bad request status
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailExceptions(EmailAlreadyExistsException ex) {
        log.warn("Email already exists: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email already exists.");
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Handles the PatientNotFoundException thrown when a patient is not found in the system.
     * Logs the exception message and returns a response entity with an error message.
     *
     * @param ex the PatientNotFoundException containing details about the error
     * @return a ResponseEntity containing a map with a user-friendly error message and a bad request status
     */
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(PatientNotFoundException ex) {
        log.warn("Patient not found: {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient not found.");
        return ResponseEntity.badRequest().body(errors);
    }

}
