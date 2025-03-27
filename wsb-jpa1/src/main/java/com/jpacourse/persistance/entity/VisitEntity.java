package com.jpacourse.persistance.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne (
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			optional = false
	)
	@JoinColumn(name = "DOCTOR_ID")
	private DoctorEntity doctor;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	// relacja ManyToOne rodzica VisitEntity do dziecka PatientEntity
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			optional = false
	)
	@JoinColumn(name = "patient_id")
	private PatientEntity patientEntity;

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

}
