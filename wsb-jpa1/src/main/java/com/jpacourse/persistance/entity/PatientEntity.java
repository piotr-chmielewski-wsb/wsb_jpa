package com.jpacourse.persistance.entity;

import java.time.LocalDate;
import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME",nullable = false)
	private String lastName;
	@Column(name = "TELEPHONE_NUMBER",nullable = false)
	private String telephoneNumber;
	@Column(name = "EMAIL",nullable = false)
	private String email;
	@Column(name = "PATIENT_NUMBER",nullable = false)
	private String patientNumber;
	@Column(name = "DATE_OF_BIRTH",nullable = false)
	private LocalDate dateOfBirth;
	@OneToOne(cascade = CascadeType.ALL,
			  fetch = FetchType.LAZY,
			  optional = false)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id")
	private AddressEntity patientAddress; // relacja OneToOne dwukierunkowa do AddressEntity
	@OneToMany(mappedBy = "patientEntityForVisits")
	private Collection<VisitEntity> patientVisits;

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

}
