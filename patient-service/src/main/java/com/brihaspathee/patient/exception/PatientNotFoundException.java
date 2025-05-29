package com.brihaspathee.patient.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 16, April 2025
 * Time: 05:16
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.exception
 * To change this template use File | Settings | File and Code Template
 */
public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
}
