package com.jpacourse.persistance.dao;

import com.jpacourse.persistance.entity.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.OptimisticLockException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;
    @Autowired
    private EntityManagerFactory emf;

    @Transactional
    @Test
    public void testShouldFindPatientByLastName() {
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

    @Test
    void shouldThrowOptimisticLockingException() {
        Long patientId = 1L;

        EntityManager em1 = emf.createEntityManager();
        em1.getTransaction().begin();
        PatientEntity patient1 = em1.find(PatientEntity.class, patientId);

        EntityManager em2 = emf.createEntityManager();
        em2.getTransaction().begin();
        PatientEntity patient2 = em2.find(PatientEntity.class, patientId);

        patient2.setFirstName("Anna");
        em2.getTransaction().commit();
        em2.close();

        patient1.setFirstName("Marek");

        assertThrows(OptimisticLockException.class, () -> {
            em1.getTransaction().commit();
        });

        em1.close();
    }
}
