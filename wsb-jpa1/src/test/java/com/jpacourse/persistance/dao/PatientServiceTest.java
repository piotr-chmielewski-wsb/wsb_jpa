package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistance.entity.DoctorEntity;
import com.jpacourse.persistance.entity.PatientEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.service.PatientService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientDao patientDao;

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
    public void testShouldDeletePatientById() {
        // given
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDescription("Visit Description");
        visitEntity.setTime(LocalDateTime.of(2001, 1, 1, 12, 30));

        List<VisitEntity> visitList = new ArrayList<>();
        visitList.add(visitEntity);

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(23L);
        patientEntity.setFirstName("Piotr");
        patientEntity.setLastName("Testowy");
        patientEntity.setTelephoneNumber("123123123");
        patientEntity.setEmail("asd@asd.sd");
        patientEntity.setPatientNumber("8763428975");
        patientEntity.setDateOfBirth(LocalDate.of(2001, 1, 1));
        patientEntity.setIsActive(true);
        patientEntity.setPatientVisits(visitList);

        // when
        final PatientEntity savedPatient = patientDao.save(patientEntity);
        assertThat(savedPatient.getId()).isNotNull();
        Long patientId = savedPatient.getId();
        patientService.deletePatientById(patientId);

        // then
        final PatientEntity patientRemoved = patientDao.findOne(savedPatient.getId());
        assertThat(patientRemoved).isNull();
    }
}
