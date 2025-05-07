package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.AddressEntity;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.Specialization;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private VisitDao visitDao;
    @Autowired
    private DoctorDao doctorDao;


    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        PatientTO patientTO = patientService.findPatientById(1L);
        // then
        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getId()).isEqualTo(1L);
    }

    @Transactional
    @Test
    public void testPatientDelete() {

        // given
        PatientEntity patientEntity = patientDao.findOne(1L);

        //when
        patientService.deletePatientById(1L);

        //then
        assertThat(patientDao.findOne(1L)).isNull();
        assertThat(visitDao.findOne(1L)).isNull(); //sprawdzanie czy wizyty zostały usunięte
        assertThat(visitDao.findOne(2L)).isNull();
        assertThat(doctorDao.findOne(1L)).isNotNull(); //sprawdzanie czy doktorzy nie zostali usunięci
        assertThat(doctorDao.findOne(2L)).isNotNull();

    }

    @Transactional
    @Test
    public void testShouldFindVisitByPatientId() {
        // given
        // when
        Collection<VisitEntity> visitEntities = patientService.findVisitsByPatientId(1L);
        // then
        assertThat(visitEntities).isNotNull();
        assertThat(visitEntities.size()).isEqualTo(2);
    }
}
