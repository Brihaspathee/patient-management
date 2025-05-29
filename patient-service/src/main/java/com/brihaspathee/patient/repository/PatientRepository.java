package com.brihaspathee.patient.repository;

import com.brihaspathee.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 6:24 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    /**
     * Checks if a patient with the specified email address exists in the database.
     *
     * @param email the email address to check for existence
     * @return true if a patient with the specified email exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Checks if a patient exists with the specified email address and a different unique identifier.
     *
     * @param email the email address of the patient to check
     * @param id the unique identifier of the patient to exclude from the search
     * @return true if a patient with the specified email exists and does not have the provided id,
     *         false otherwise
     */
    boolean existsByEmailAndIdNot(String email, UUID id);
}
