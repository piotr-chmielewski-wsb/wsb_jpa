--drop all objects

--ADDRESSES
insert into address (id, address_line_1, address_line_2, city, postal_code)
values (1, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line_1, address_line_2, city, postal_code)
values (2, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line_1, address_line_2, city, postal_code)
values (3, 'xx', 'yy', 'city', '60-400');


--DOCTORS
insert into doctor (address_id, id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (1, 1, '1', 'testmail', 'Bonus', 'BGC', '2222', 'OCULIST');
insert into doctor (address_id, id, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (2, 2, '2', 'testmail2', 'Janusz', 'Tracz', '22212', 'OCULIST');


--PATIENTS
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_active)
values (1, 'Piotr', 'Kowalski', '123456789', 'asd@sd.pl', '1542343', '2001-12-12', 1, true);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_active)
values (2, 'Marcin', 'Nowak', '123456780', 'asd@sd.pl', '1542344', '1960-12-12', 2, false);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_active)
values (3, 'Janusz', 'Nowak', '123433234', 'asd@sd.pl', '1542345', '1962-08-12', 3, true);


--VISITS
insert into visit (id, description, time, patient_id, doctor_id)
values (1, '1 visit', '2025-01-27T17:55:15.490739', 1, 1);
insert into visit (id, description, time, patient_id, doctor_id)
values (2, '2 visit', '2025-03-27T17:55:15.490739', 1, 2);
insert into visit (id, description, time, patient_id, doctor_id)
values (3, '3 visit', '2025-04-02T17:55:15.490739', 2, 2);
insert into visit (id, description, time, patient_id, doctor_id)
values (4, '4 visit', '2025-05-27T17:55:15.490739', 2, 1);



--MEDICAL_TREATMENT
insert into medical_treatment (id, description, treatment_type, visit_id)
values (1, 'USG treatment', 'USG', 1);
insert into medical_treatment (id, description, treatment_type, visit_id)
values (2, 'USG treatment', 'EKG', 1);
insert into medical_treatment (id, description, treatment_type, visit_id)
values (3, 'USG treatment', 'RTG', 2);
insert into medical_treatment (id, description, treatment_type, visit_id)
values (4, 'USG treatment', 'EKG', 3);