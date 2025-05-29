package com.brihaspathee.patient.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 16, April 2025
 * Time: 04:58
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.exception
 * To change this template use File | Settings | File and Code Template
 */
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new EmailAlreadyExistsException with the specified detail message.
     *
     * @param message the detail message indicating the cause or reason of the exception
     */
    public EmailAlreadyExistsException(String message) {
        super(message);
    }

    /**
     * Constructs a new EmailAlreadyExistsException with the specified detail message and cause.
     *
     * @param message the detail message*/
    public EmailAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
