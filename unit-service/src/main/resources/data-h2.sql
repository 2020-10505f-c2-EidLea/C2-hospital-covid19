INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(1, 'A', 1);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(2, 'B', 2);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(3, 'C', 3);

INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(1, 10, 'Floor1', 'Normal Rooms');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(2, 11, 'Floor2', 'Laboratory');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(3, 12, 'Floor3', 'Patients Rooms');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(4, 13, 'Floor4', 'Administration');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(5, 14, 'Floor5', 'Operations Rooms');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(6, 15, 'Floor6', 'Quarantine Rooms');

INSERT INTO TBL_TYPES (id, name, description) VALUES(1, 'TYPE 1', 'TYPE 1');
INSERT INTO TBL_TYPES (id, name, description) VALUES(2, 'TYPE 2', 'TYPE 2');
INSERT INTO TBL_TYPES (id, name, description) VALUES(3, 'TYPE 3', 'TYPE 3');
INSERT INTO TBL_TYPES (id, name, description) VALUES(4, 'TYPE 4', 'TYPE 4');

INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(1, 10, 1, 1, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(2, 11, 1, 2, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(3, 12, 2, 2, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(4, 13, 1, 3, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(5, 14, 2, 3, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(6, 15, 3, 3, 1, 1, 4);

INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(7, 20, 1, 1, 3, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(8, 21, 1, 2, 3, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(9, 22, 2, 2, 3, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(10, 23, 1, 3, 3, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(11, 24, 2, 3, 3, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(12, 25, 3, 3, 3, 1, 4);

INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(13, 30, 1, 1, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(14, 31, 1, 2, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(15, 32, 2, 2, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(16, 33, 1, 3, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(17, 34, 2, 3, 1, 1, 4);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, is_available, nbr_reserved_beds) VALUES(18, 35, 3, 3, 1, 1, 4);
