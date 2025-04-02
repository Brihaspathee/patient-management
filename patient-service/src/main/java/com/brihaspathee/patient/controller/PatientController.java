package com.brihaspathee.patient.controller;

import com.brihaspathee.patient.dto.PatientRequestDto;
import com.brihaspathee.patient.dto.PatientResponseDto;
import com.brihaspathee.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PatientResponseDto> savePatient(@Valid
                                                              @RequestBody
                                                              PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.savePatient(patientRequestDto);
        return new ResponseEntity<>(patientResponseDto, HttpStatus.CREATED);
    }

}
