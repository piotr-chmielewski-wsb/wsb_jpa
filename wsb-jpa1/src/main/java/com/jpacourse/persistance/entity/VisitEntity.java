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
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			optional = false
	)
	@JoinColumn(name = "PATIENT_ID", referencedColumnName = "id") // relacja ManyToOne dwukierunkowa VisitEntity do PatientEntity
	private PatientEntity patientEntityForVisits;
	@ManyToOne (
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			optional = false
	)
	@JoinColumn(name = "DOCTOR_ID", referencedColumnName = "id")
	private DoctorEntity doctorEntityForVisits;
	@OneToMany(mappedBy = "visitEntityforMedicalTreatment")
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
}
