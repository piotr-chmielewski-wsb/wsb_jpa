package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.PatientEntity;

public final class PatientMapper
{
    public static PatientTO mapToTO(final PatientEntity patientEntity)
    {
        if(patientEntity == null)
        {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(String.valueOf(patientEntity.getTelephoneNumber()));
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(String.valueOf(patientEntity.getPatientNumber()));
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        return patientTO;
    }
    public static PatientEntity mapToEntity(final PatientTO patientTO)
    {
        if(patientTO == null)
        {
            return null;
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        return patientEntity;
    }
}
