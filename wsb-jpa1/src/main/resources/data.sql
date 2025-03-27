-- drop all objects

insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (address_id, id, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values ( 901,1,'1','testmail','Bonus','BGC','2222','OCULIST');

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_entity_id)
            values (123, 'Piotr', 'Kowalski', '123456789', 'asd@sd.pl', '1542343', '2001-12-12', 901);

insert into visit (id, description, time, patient_id, doctor_id)
            values (232, 'desc', '2025-03-27T17:55:15.490739', 123, 1);

insert into medical_treatment (id, description, type, visit_id)
            values (567, 'desc', 'USG', 232);