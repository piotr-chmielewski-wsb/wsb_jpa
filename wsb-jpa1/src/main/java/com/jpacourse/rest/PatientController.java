package com.jpacourse.rest;


import com.jpacourse.dto.PatientTO;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController
{
    private final PatientService patientService;

    public PatientController(PatientService patientService) {this.patientService = patientService;}

    @GetMapping("/patient/{id}")
    PatientTO findBaId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findPatientById(id);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @DeleteMapping("/patient/{id}")
    void deleteBaId(@PathVariable final Long id) {
        patientService.deletePatientById(id);
    }
}
