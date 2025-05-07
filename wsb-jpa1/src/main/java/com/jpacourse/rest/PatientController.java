package com.jpacourse.rest;


import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController
{
    private final PatientService patientService;

    public PatientController(PatientService patientService) {this.patientService = patientService;}

    @GetMapping()
    List<PatientTO> findBaLastName(@RequestParam(name = "lastName", required = false) String lastName,
                                   @RequestParam(name = "visits", required = false) Integer visits,
                                   @RequestParam(name = "isActive", required = false) Boolean isActive) {
        if (lastName != null) {
            return patientService.findPatientByLastName(lastName);
        } else if (visits != null) {
            return patientService.findByVisitCount(visits);
        } else if (isActive != null) {
            return  patientService.findActive(isActive);
        } else {
            return null;
        }
    }

    @GetMapping("/visits/{id}")
    Collection<VisitEntity> findVisitsByPatientId(@PathVariable final Long id) {
        return patientService.findVisitsByPatientId(id);
    }

    @GetMapping("{id}")
    PatientTO findBaId(@PathVariable final Long id) {
        final PatientTO patient = patientService.findPatientById(id);
        if(patient != null)
        {
            return patient;
        }
        throw new EntityNotFoundException(id);
    }

    @DeleteMapping("{id}")
    void deleteBaId(@PathVariable final Long id) {
        patientService.deletePatientById(id);
    }
}
