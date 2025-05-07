package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistance.dao.PatientDao;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao pPatientDao)
    {
        patientDao = pPatientDao;
    }

    @Override
    public PatientTO findPatientById(Long id){
        final PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public void deletePatientById(Long id){
        patientDao.delete(id);
    }

    @Override
    public List<PatientTO> findPatientByLastName(String lastName){
        final List<PatientEntity> entityList = patientDao.findByLastName(lastName);
        return PatientMapper.mapToTOList(entityList);
    }

    @Override
    public Collection<VisitEntity> findVisitsByPatientId(Long id){
        final PatientEntity entity = patientDao.findOne(id);
        return entity.getPatientVisits();
    }

    @Override
    public List<PatientTO> findByVisitCount(int visitCount) {
        final List<PatientEntity> entityList = patientDao.findByVisitCount(visitCount);
        return PatientMapper.mapToTOList(entityList);
    }

    @Override
    public  List<PatientTO> findActive(boolean isActive){
        final List<PatientEntity> entityList = patientDao.findActive(isActive);
        return PatientMapper.mapToTOList(entityList);
    }
}
