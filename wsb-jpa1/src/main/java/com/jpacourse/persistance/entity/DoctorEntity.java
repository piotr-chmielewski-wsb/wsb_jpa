package com.jpacourse.persistance.entity;

import com.jpacourse.persistance.enums.Specialization;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FIRST_NAME",nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME",nullable = false)
	private String lastName;
	@Column(name = "TELEPHONE_NUMBER",nullable = false)
	private String telephoneNumber;
	@Column(name = "EMAIL" ,nullable = false)
	private String email;
	@Column(name = "DOCTOR_NUMBER" ,nullable = false)
	private String doctorNumber;
	@Column(name = "SPECIALIZATION",nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;
	@OneToOne (cascade = CascadeType.ALL,
			   fetch = FetchType.EAGER,
			   optional = false)
	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "id") // relacja OneToOne dwukierunkowa DoctorEntity z AddressEntity
	private AddressEntity doctorAddress;
	@OneToMany(mappedBy = "doctorEntityForVisits", cascade = CascadeType.ALL)
	private Collection<VisitEntity> doctorVisits;

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

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

}
