package com.jpacourse.dto;

import com.jpacourse.persistance.entity.VisitEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;


public class PatientTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private Collection<VisitInformations> visitInformations = new ArrayList<>();


    public static class VisitInformations implements Serializable {
        private LocalDateTime time;
        private String doctorFirstName;
        private String doctorLastName;

        public LocalDateTime getTime() {
            return time;
        }
        public void setTime(LocalDateTime time) {
            this.time = time;
        }
        public String getDoctorFirstName() {
            return doctorFirstName;
        }
        public void setDoctorFirstName(String doctorFirstName) {
            this.doctorFirstName = doctorFirstName;
        }
        public String getDoctorLastName() {
            return doctorLastName;
        }
        public void setDoctorLastName(String doctorLastName) {
            this.doctorLastName = doctorLastName;
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Collection<VisitInformations> getVisitInformations() {
        return visitInformations;
    }
    public void setVisitInformations(Collection<VisitEntity> patientVisits) {
        Collection<VisitInformations> visitInfos = new ArrayList<>();
        for( VisitEntity visit : patientVisits )
        {
            VisitInformations visitInfo = new VisitInformations();
            visitInfo.time = visit.getTime();
            visitInfo.doctorFirstName = visit.getDoctorEntityForVisits().getFirstName();
            visitInfo.doctorLastName = visit.getDoctorEntityForVisits().getLastName();
            visitInfos.add(visitInfo);
        }
        this.visitInformations = visitInfos;
    }
}
