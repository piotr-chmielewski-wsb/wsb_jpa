package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "TIME",nullable = false)
	private LocalDateTime time;
	@ManyToOne(
			fetch = FetchType.EAGER,
			optional = true
	)
	@JoinColumn(name = "PATIENT_ID", referencedColumnName = "id") // relacja ManyToOne dwukierunkowa VisitEntity do PatientEntity
	private PatientEntity patientEntityForVisits;
	@ManyToOne (
			fetch = FetchType.EAGER,
			optional = true
	)
	@JoinColumn(name = "DOCTOR_ID", referencedColumnName = "id")
	private DoctorEntity doctorEntityForVisits;
	@OneToMany(mappedBy = "visitEntityforMedicalTreatment", cascade = CascadeType.REMOVE)
	private Collection<MedicalTreatmentEntity> medicalTreatmentEntityList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctorEntityForVisits() {
		return doctorEntityForVisits;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatmentEntityList() {
		return medicalTreatmentEntityList;
	}

	public void setPatientEntityForVisits(PatientEntity patientEntityForVisits) {
		this.patientEntityForVisits = patientEntityForVisits;
	}

	public void setDoctorEntityForVisits(DoctorEntity doctorEntityForVisits) {
		this.doctorEntityForVisits = doctorEntityForVisits;
	}
}
