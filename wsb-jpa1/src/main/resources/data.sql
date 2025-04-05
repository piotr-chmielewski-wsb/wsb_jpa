 --drop all objects

 insert into address (id, address_line_1, address_line_2, city, postal_code)
             values (1, 'xx', 'yy', 'city', '60-400');

insert into doctor (address_id, id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values ( 1,1,'1','testmail','Bonus','BGC','2222','OCULIST');

 insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id)
            values (1, 'Piotr', 'Kowalski', '123456789', 'asd@sd.pl', '1542343', '2001-12-12', 1);

insert into visit (id, description, time, patient_id, doctor_id)
            values (1, '1 visit', '2025-01-27T17:55:15.490739', 1, 1);

insert into visit (id, description, time, patient_id, doctor_id)
            values (2, '2 visit', '2025-03-27T17:55:15.490739', 1, 1);

insert into visit (id, description, time, patient_id, doctor_id)
            values (3, '3 visit', '2025-04-27T17:55:15.490739', 1, 1);

insert into visit (id, description, time, patient_id, doctor_id)
            values (4, '4 visit', '2025-05-27T17:55:15.490739', 1, 1);

insert into medical_treatment (id, description, treatment_type, visit_id)
            values (1, 'USG treatment', 'USG', 1);