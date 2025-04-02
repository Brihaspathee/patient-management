package com.brihaspathee.patient.dto;

import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 6:56 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.dto
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {

    /**
     * Represents the unique identifier for a Patient entity.
     * This variable is used to distinctly identify a patient
     * in the system.
     */
    private String id;

    /**
     * Represents the name of the patient.
     * It is used to identify the patient by their full name.
     */
    private String name;

    /**
     * Represents the email address of the patient.
     * It is used to uniquely identify and communicate with the patient electronically.
     */
    private String email;

    /**
     * Represents the address associated with the patient.
     * It typically contains details such as street, city, state, and postal code.
     */
    private String address;

    /**
     * Represents the date of birth of the patient.
     * It is stored as a String in the format 'YYYY-MM-DD'.
     */
    private String dateOfBirth;
}
