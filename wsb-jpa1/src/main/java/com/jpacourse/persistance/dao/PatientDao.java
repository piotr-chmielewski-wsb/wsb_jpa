package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;

import java.time.LocalDateTime;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    VisitEntity addVisit(PatientEntity patient, DoctorEntity doctor, LocalDateTime visitTime, String description);
}
