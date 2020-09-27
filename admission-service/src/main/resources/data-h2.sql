INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (1, 1, null, '2020-09-01T21:32:29', '2020-09-01T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (2, 1, null, '2020-09-02T21:32:29', '2020-09-02T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (3, 1, null, '2020-09-03T21:32:29', '2020-09-03T21:35:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (4, 1, null, '2020-09-04T21:32:29', '2020-09-04T21:40:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (5, 5, null, '2020-09-05T21:32:29', '2020-09-09T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (6, 7, 1, '2020-09-06T21:32:29', '2020-09-13T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (7, 15, 8, '2020-09-07T21:32:29', '2020-09-22T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (8, 1, null, '2020-09-10T21:32:29', '2020-09-10T21:32:29');
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (9, 1, null, '2020-09-10T21:32:29', null);
INSERT INTO TBL_ADMISSION (id, nbr_of_days, room_id, check_in, check_out) VALUES (10, 1, 2, '2020-09-16T21:32:29', null);

INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(1, 'Test Covid19', true);
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(2, 'Intensive Care', true);
INSERT INTO TBL_SERVICE (id, description, available_service) VALUES(3, 'In Hospital', true);

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(1, 1, 1, '2020-09-01T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(2, 1, 2, '2020-09-02T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(3, 1, 3, '2020-09-03T21:32:29', 'Positive');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(4, 2, 4, '2020-09-04T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(5, 3, 5, '2020-09-09T21:32:29', 'Positive');

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(6, 1, 6, '2020-09-05T21:32:29', 'Positive');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(7, 1, 6, '2020-09-25T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(8, 2, 6, '2020-09-25T21:32:29', 'Discharge');

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(9, 1, 7, '2020-09-05T21:32:29', 'Positive');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(10, 2, 7, '2020-09-06T21:32:29', 'Death');

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(11, 1, 8, '2020-09-10T21:32:29', 'Positive');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(12, 2, 8, '2020-09-10T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(13, 3, 8, '2020-09-10T21:32:29', 'Discharge');

INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(14, 1, 9, '2020-09-10T21:32:29', 'Negative');
INSERT INTO TBL_ADMISSION_SERVICE(id, service_id, admission_id, service_date, service_result) values(15, 2, 10, '2020-09-18T21:32:29', 'Negative');