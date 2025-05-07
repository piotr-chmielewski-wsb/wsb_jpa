package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // given
        // when
        List<PatientEntity> patientEntity = patientDao.findByLastName("Nowak");
        // then
        assertThat(patientEntity).isNotNull();
        assertThat(patientEntity.size()).isEqualTo(2);
    }

    @Transactional
    @Test
    public void testfindByVisitCount(){

        //when
        List<PatientEntity> patients = patientDao.findByVisitCount(1);
        //then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(2);

    }
    @Transactional
    @Test
    public void testFindByActive(){
        //when
        List<PatientEntity> patients = patientDao.findActive(true);
        //then
        assertThat(patients).isNotNull();
        assertThat(patients.size()).isEqualTo(2);
    }
}
