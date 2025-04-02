package com.brihaspathee.patient.service;

import com.brihaspathee.patient.dto.PatientRequestDto;
import com.brihaspathee.patient.dto.PatientResponseDto;
import com.brihaspathee.patient.mapper.PatientMapper;
import com.brihaspathee.patient.model.Patient;
import com.brihaspathee.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 6:27 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.service
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PatientService {

    /**
     * Handles data access operations for the Patient entity.
     * This repository provides CRUD operations and extends the JpaRepository
     * interface, which offers additional functionality such as pagination and sorting.
     *
     * It is a key dependency for the PatientService class, enabling interaction
     * with the underlying database for managing patient information.
     */
    private final PatientRepository patientRepository;

    /**
     * Retrieves the list of all patients from the repository and maps them to
     * PatientResponseDto objects.
     *
     * @return a list of PatientResponseDto instances, each representing the details
     *         of a patient in a structured form.
     */
    public List<PatientResponseDto> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients
                .stream()
                .map(PatientMapper::patientToPatientResponseDto)
                .toList();
    }

    /**
     * Saves the provided patient information into the database.
     *
     * @param patientRequestDto an object containing the details of the patient to be saved
     * @return the saved Patient entity
     */
    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto) {
        Patient patient = PatientMapper.patientRequestDtoToPatient(patientRequestDto);
        return PatientMapper.patientToPatientResponseDto(patientRepository.save(patient));
    }
}
