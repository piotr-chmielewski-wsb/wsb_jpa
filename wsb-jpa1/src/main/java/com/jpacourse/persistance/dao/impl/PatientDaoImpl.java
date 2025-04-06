package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public VisitEntity addVisit(PatientEntity patient, DoctorEntity doctor, LocalDateTime visitTime, String description){
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setPatientEntityForVisits(patient);
        visitEntity.setDoctorEntityForVisits(doctor);
        visitEntity.setTime(visitTime);
        visitEntity.setDescription(description);

        entityManager.persist(visitEntity);
        patient.getPatientVisits().add(visitEntity);
        entityManager.merge(patient);
        return visitEntity;
    }
}
