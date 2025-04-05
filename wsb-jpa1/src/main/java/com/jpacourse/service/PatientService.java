package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

public interface PatientService
{
    PatientTO findPatientById(final Long id);
}
