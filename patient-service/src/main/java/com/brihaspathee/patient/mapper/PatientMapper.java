package com.brihaspathee.patient.mapper;

import com.brihaspathee.patient.dto.PatientRequestDto;
import com.brihaspathee.patient.dto.PatientResponseDto;
import com.brihaspathee.patient.model.Patient;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 4/2/25
 * Time: 7:00 PM
 * Project: patient-management
 * Package Name: com.brihaspathee.patient.mapper
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class PatientMapper {

    /**
     * Converts a Patient entity to a PatientResponseDto object.
     *
     * @param patient the Patient entity to convert, which contains fields such as id, name, email, address,
     *                and dateOfBirth. If the supplied patient object is null, this method will return null.
     * @return a PatientResponseDto object containing the relevant patient details such as id, name, email,
     *         address, and dateOfBirth, formatted as strings. Returns null if the input patient is null.
     */
    public static PatientResponseDto patientToPatientResponseDto(Patient patient) {
        if(patient == null) return null;
        return PatientResponseDto.builder()
                .id(patient.getId().toString())
                .name(patient.getName())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .build();
    }

    /**
     * Converts a PatientRequestDto object to a Patient entity.
     *
     * @param patientRequestDto the PatientRequestDto object containing patient details such as name,
     *                          email, address, date of birth, and registered date. If the input object is null,
     *                          the method returns null.
     * @return a Patient entity populated with the corresponding details from the PatientRequestDto input.
     *         Returns null if the input is null.
     */
    public static Patient patientRequestDtoToPatient(PatientRequestDto patientRequestDto) {
        if (patientRequestDto == null) return null;
        Patient patient = Patient.builder()
                .name(patientRequestDto.getName())
                .email(patientRequestDto.getEmail())
                .address(patientRequestDto.getAddress())
                .dateOfBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()))
                .registeredDate(LocalDate.parse(patientRequestDto.getRegisteredDate()))
                .build();
        return patient;
    }
}
