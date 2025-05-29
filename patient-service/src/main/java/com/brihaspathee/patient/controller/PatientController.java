package com.brihaspathee.patient.controller;

import com.brihaspathee.patient.dto.PatientRequestDto;
import com.brihaspathee.patient.dto.PatientResponseDto;
import com.brihaspathee.patient.dto.validators.CreatePatientValidationGroup;
import com.brihaspathee.patient.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 7:07 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.controller
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/patients")
@Tag(name = "Patient Management API", description = "API for managing patient data")
@RequiredArgsConstructor
public class PatientController {

    /**
     * The PatientService instance is a dependency for the PatientController class
     * and is responsible for handling all service-level operations related to
     * managing patient data.
     *
     * This variable is declared as final, ensuring that its reference cannot be
     * changed once initialized, and is injected through constructor-based
     * dependency injection facilitated by the @RequiredArgsConstructor annotation.
     */
    private final PatientService patientService;

    /**
     * Retrieves a list of patients and returns their details as a structured response.
     *
     * @return ResponseEntity containing a list of PatientResponseDto instances,
     *         each representing the details of a patient.
     */
    @GetMapping
    @Operation(summary = "Get all patients", description = "Returns a list of all patients")
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    /**
     * Saves the details of a patient and returns a response with HTTP status code 201 (CREATED).
     *
     * @param patientRequestDto the data transfer object containing the patient's details to be saved
     * @return ResponseEntity with an empty body and HTTP status code 201 (CREATED) indicating successful operation
     */
    @PostMapping
    @Operation(summary = "Create a patient", description = "Creates a new patient record")
    public ResponseEntity<PatientResponseDto> createPatient(@Validated({Default.class, CreatePatientValidationGroup.class})
                                                              @RequestBody
                                                              PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.savePatient(patientRequestDto);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.CREATED);
    }

    /**
     * Updates the details of an existing patient identified by their unique ID.
     *
     * @param id the unique identifier of the patient to be updated
     * @param patientRequestDto the data transfer object containing the updated details of the patient
     * @return ResponseEntity containing the updated patient details encapsulated in a PatientResponseDto
     *         and a status code of 200 (OK) indicating the operation was successful
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a patient", description = "Updates the details of an existing patient")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable UUID id,
                                                            @Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.updatePatient(id, patientRequestDto);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.OK);
    }

    /**
     * Deletes a patient identified by their unique ID.
     *
     * @param id the unique identifier of the patient to be deleted
     * @return ResponseEntity with an empty body and HTTP status code 204 (NO_CONTENT),
     *         indicating the patient was successfully deleted.
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a patient", description = "Deletes a patient record")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
