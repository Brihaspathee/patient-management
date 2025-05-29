package com.brihaspathee.patient.service;

import com.brihaspathee.patient.dto.PatientRequestDto;
import com.brihaspathee.patient.dto.PatientResponseDto;
import com.brihaspathee.patient.exception.EmailAlreadyExistsException;
import com.brihaspathee.patient.exception.PatientNotFoundException;
import com.brihaspathee.patient.mapper.PatientMapper;
import com.brihaspathee.patient.model.Patient;
import com.brihaspathee.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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
        String patientEmail = patientRequestDto.getEmail();
        log.info("Saving patient with email {}", patientEmail);
        if(patientRepository.existsByEmail(patientEmail)){
            throw new EmailAlreadyExistsException("Patient with email " + patientEmail + " already exists");
        }
        Patient patient = PatientMapper.patientRequestDtoToPatient(patientRequestDto);
        return PatientMapper.patientToPatientResponseDto(patientRepository.save(patient));
    }

    /**
     * Updates the details of an existing patient identified by the specified UUID.
     * Validates whether the provided information, such as email, does not conflict with
     * other existing patients. If a patient with the given ID does not exist, an exception
     * is thrown. The updated patient details are mapped and returned as a response object.
     *
     * @param id the unique identifier of the patient to be updated
     * @param patientRequestDto the data transfer object containing updated patient information
     *                          such as name, email, address, and date of birth
     * @return a PatientResponseDto containing the updated details of the patient
     * @throws PatientNotFoundException if no patient is found with the specified ID
     * @throws EmailAlreadyExistsException if the updated email already exists for another patient
     */
    public PatientResponseDto updatePatient(UUID id,
                                            PatientRequestDto patientRequestDto) {
        Patient patient = patientRepository.findById(id).orElseThrow(()->
                new PatientNotFoundException("Patient with id " + id + " not found"));
        String patientEmail = patientRequestDto.getEmail();
        if(patientRepository.existsByEmailAndIdNot(patientEmail, id)){
            throw new EmailAlreadyExistsException("Patient with email " + patientEmail + " already exists");
        }
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.patientToPatientResponseDto(updatedPatient);
    }

    /**
     * Deletes a patient identified by the specified unique identifier.
     *
     * @param id the unique identifier of the patient to be deleted
     */
    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }
}
