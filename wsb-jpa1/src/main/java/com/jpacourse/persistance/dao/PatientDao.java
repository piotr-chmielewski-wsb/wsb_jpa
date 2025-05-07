package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long>
{
    List<PatientEntity> findByLastName(String lastName);

    List<PatientEntity> findByVisitCount(int visitCount);

    List<PatientEntity> findActive(boolean isActive);
}
