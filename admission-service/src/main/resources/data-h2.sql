INSERT INTO TBL_ADMISSION (id, nbr_of_days, check_in, check_out) VALUES (1, 14, '2020-09-01T21:32:29', '2020-09-15T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, check_in, check_out) VALUES (2, 14, '2020-09-02T21:32:29', '2020-09-16T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, check_in, check_out) VALUES (3, 13, '2020-09-03T21:32:29', '2020-09-17T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, check_in, check_out) VALUES (4, 12, '2020-09-04T21:32:29', '2020-09-18T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, check_in, check_out) VALUES (5, 12, '2020-09-05T21:32:29', '2020-09-19T21:32:29');

INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(1, 'Admission Service1', '1');
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(2, 'Admission Service2', '2');
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(3, 'Admission Service3', '3');
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(4, 'Admission Service4', '4');
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(5, 'Admission Service5', '5');

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(1, 1, 1, '2020-09-01T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(2, 1, 2, '2020-08-21T11:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(3, 1, 3, '2020-08-11T01:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(4, 2, 4, '2020-05-12T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(5, 2, 5, '2020-01-14T13:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(6, 3, 2, '2020-02-18T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(7, 4, 4, '2020-04-28T14:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(8, 4, 5, '2020-03-31T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(9, 5, 2, '2020-02-28T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(10, 5, 3, '2020-01-28T21:32:29', 'Done.');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(11, 4, 3, '2020-07-27T21:32:29', 'Done.');