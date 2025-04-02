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
}
