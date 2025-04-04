package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.TreatmentType;

import jakarta.persistence.*;

@Entity
@Table(name = "MEDICAL_TREATMENT")
public class MedicalTreatmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;
	@Column(name = "TREATMENT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private TreatmentType type;
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			optional = false
	)
	@JoinColumn(name = "VISIT_ID", referencedColumnName = "id") // relacja ManyToOne dwukierunkowa MedicalTreatmentEntity do VisitEntity
	private VisitEntity visitEntityforMedicalTreatment;

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

	public TreatmentType getType() {
		return type;
	}

	public void setType(TreatmentType type) {
		this.type = type;
	}

}
