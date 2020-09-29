INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (1, 'Tony', 'Touma', 'Tannoury', '1990-01-14T21:32:29', 'M', 'Beirut', '03427586', 'tony.touma@hotmail.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (2, 'William', 'Constatine', 'Haber', '1992-06-18T21:32:29', 'M', 'Tikrit', '03495186', 'william@gmail.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (3, 'Bassam', 'Jebara', 'Gebran', '1994-07-11T21:32:29', 'M', 'Akkar', '03427753', 'bassam_gebran@yahoo.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (4, 'Ziad', 'Issam', 'Toufic', '1998-05-24T21:32:29', 'M', 'Jnoub', '034277561', 'Toufic12453@live.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (5, 'Hanna', 'Hasrouny', 'Abded', '1991-11-22T21:32:29', 'M', 'Saida', '034875880', 'Hannaabded@mail.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (6, 'Jad', 'Walid', 'Abbas', '1991-11-22T21:32:29', 'M', 'Saida', '03875740', 'JadAbbas@mail.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (7, 'Jamila', 'Mohammad', 'Hajjali', '1991-11-22T21:32:29', 'F', 'Saida', '03853880', 'JamilaHajjali@mail.com');
INSERT INTO TBL_PROFILE(id, first_name, middle_name, last_name, birthdate, gender, address, phone, email) VALUES (8, 'Farah', 'Chahid', 'Bitar', '1991-11-22T21:32:29', 'F', 'Saida', '03745811', 'FarahBitar@mail.com');


INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(1, 1, 1, 'coronavirus test', 'Negative');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(2, 2, 2, 'coronavirus test', 'Negative');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(3, 3, 3, 'coronavirus test', 'Positive');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(4, 3, 9, 'coronavirus test', 'Negative');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(5, 4, 5, 'coronavirus test', 'Positive');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(6, 4, 10, 'coronavirus test', 'Death');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(7, 5, 4, 'coronavirus test', 'Negative');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(8, 6, 6, 'In Hospital Respiratory Problems', 'Discharge');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(9, 7, 7, 'In Hospital with w heart disease', 'Death');
INSERT INTO TBL_HISTORY(id, profile_id, admission_id, description, result) VALUES(10, 8, 8, 'In Hospital', 'Discharge');