package com.jpacourse.persistance.dao.impl;

import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{

    @Override
    public List<PatientEntity> findByLastName(String lastName) {
        String jpqlQuery = "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName";

        TypedQuery<PatientEntity> query = entityManager.createQuery(jpqlQuery, PatientEntity.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findByVisitCount(int count) {
        String jpqlQuery = "SELECT p FROM PatientEntity p WHERE SIZE(p.patientVisits) > :count ";
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpqlQuery, PatientEntity.class);
        query.setParameter("count", count);
        return query.getResultList();
    }

    @Override
    public List<PatientEntity> findActive(boolean isActive) {
        String jpqlQuery = "SELECT p FROM PatientEntity p WHERE p.isActive = :isActive";;
        TypedQuery<PatientEntity> query = entityManager.createQuery(jpqlQuery, PatientEntity.class);
        query.setParameter("isActive", isActive);
        return query.getResultList();
    }
}
