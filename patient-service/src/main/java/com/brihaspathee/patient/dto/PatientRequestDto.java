package com.brihaspathee.patient.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 7:18 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.dto
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequestDto {

    /**
     * Represents the name of the patient.
     * This field is mandatory and must not be null or blank.
     * The name must not exceed 100 characters.
     */
    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    /**
     * Represents the email address of the patient.
     * This field is required and must not be null or blank.
     * Additionally, it must conform to a valid email format.
     */
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * Represents the address of the patient.
     * This field is mandatory and must not be null or blank.
     * It generally contains the street, city, state, and postal code.
     */
    @NotBlank(message = "Address is required")
    @NotNull(message = "Address is required")
    private String address;

    /**
     * Represents the date of birth of the patient.
     * This field is mandatory and must not be null or blank.
     * It is stored as a String and should adhere to a valid date format.
     */
    @NotBlank(message = "Date of birth is required")
    @NotNull(message = "Date of birth is required")
    private String dateOfBirth;

    /**
     * Represents the date when the patient was registered in the system.
     * This field is mandatory and should not be null or blank.
     */
    @NotBlank(message = "Registered date is required")
    @NotNull(message = "Registered date is required")
    private String registeredDate;

}
