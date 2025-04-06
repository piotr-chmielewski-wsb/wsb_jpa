package com.jpacourse.dto;

import com.jpacourse.persistance.entity.MedicalTreatmentEntity;
import com.jpacourse.persistance.entity.VisitEntity;
import com.jpacourse.persistance.enums.TreatmentType;

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
    private Boolean isActive;
    private Collection<CompletedVisits> completedVisits = new ArrayList<>();


    public static class CompletedVisits implements Serializable {
        private LocalDateTime time;
        private String doctorFirstName;
        private String doctorLastName;
        private Collection<TreatmentType> typesOfTreatment = new ArrayList<>();

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

        public Collection<TreatmentType> getTypesOfTreatment() {
            return typesOfTreatment;
        }

        public void setTypesOfTreatment(Collection<TreatmentType> typesOfTreatment) {
            this.typesOfTreatment = typesOfTreatment;
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

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<CompletedVisits> getCompletedVisits() {
        return completedVisits;
    }

    public void setCompletedVisits(Collection<VisitEntity> patientVisits) {
        Collection<CompletedVisits> visitInfos = new ArrayList<>();
        for (VisitEntity visit : patientVisits) {
            if (visit.getTime().isBefore(LocalDateTime.now())) {
                CompletedVisits visitInfo = new CompletedVisits();
                visitInfo.time = visit.getTime();
                visitInfo.doctorFirstName = visit.getDoctorEntityForVisits().getFirstName();
                visitInfo.doctorLastName = visit.getDoctorEntityForVisits().getLastName();
                for ( MedicalTreatmentEntity medicalTreatment : visit.getMedicalTreatmentEntityList() ) {
                    visitInfo.typesOfTreatment.add(medicalTreatment.getType());
                }
                visitInfos.add(visitInfo);
            }
        }
        this.completedVisits = visitInfos;
    }



}
