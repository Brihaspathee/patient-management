package com.brihaspathee.patient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 5:49 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.model
 * To change this template use File | Settings | File and Code Template
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    /**
     * Represents the unique identifier for the Patient entity.
     * This field is automatically generated using a UUID strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    /**
     * Represents the name of the patient.
     * This field is mandatory and cannot be null.
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * Represents the email address of the patient.
     * This field is mandatory, must be unique, and should follow a valid email format.
     */
    @Email
    @NotNull
    @Column(unique = true, name = "email")
    private String email;

    /**
     * Represents the address of the patient.
     * This field is mandatory and cannot be null.
     */
    @NotNull
    @Column(name = "address")
    private String address;

    /**
     * Represents the date of birth of the patient.
     * This field is mandatory and cannot be null.
     */
    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    /**
     * The date when the patient was registered in the system.
     * This field is mandatory and cannot be null.
     */
    @NotNull
    @Column(name = "registered_date")
    private LocalDate registeredDate;

}
