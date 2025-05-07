package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.VisitEntity;

import java.util.Collection;
import java.util.List;

public interface PatientService
{
    PatientTO findPatientById(final Long id);

    void deletePatientById(final Long id);

    List<PatientTO> findPatientByLastName(final String lastName);

    Collection<VisitEntity> findVisitsByPatientId(final Long id);

    List<PatientTO> findByVisitCount(final int visitCount);

    List<PatientTO> findActive(boolean isActive);
}
