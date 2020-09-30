INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(1, 'A', 1);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(2, 'B', 2);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(3, 'C', 3);

INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(1, 1, 'Bloc A', 'Laboratory');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(2, 2, 'Bloc A', 'Quarantine Rooms');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(3, 3, 'Bloc A', 'Operations Bloc');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(4, 4, 'Bloc B', 'Isolated Section');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(5, 5, 'Bloc B', 'Intensive Care Section');

INSERT INTO TBL_TYPES (id, name, description) VALUES(1, 'Normal', 'Normal reception unit'); -- class A /B /C
INSERT INTO TBL_TYPES (id, name, description) VALUES(2, 'Isolated', 'Isolated for low imunity patients'); -- class A
INSERT INTO TBL_TYPES (id, name, description) VALUES(3, 'ICU', 'Intensive Care Unit'); --class A
INSERT INTO TBL_TYPES (id, name, description) VALUES(4, 'CCU', 'Cardiac Care Unit'); --class A / B
INSERT INTO TBL_TYPES (id, name, description) VALUES(5, 'Operation', 'Operation Rooms'); --class A

-- Quarantine Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(1, 220, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(2, 221, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(3, 222, 1, 2, 2, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(4, 223, 1, 2, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(5, 224, 1, 2, 2, true, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(6, 225, 1, 3, 2, false, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(19, 226, 1, 3, 2, true, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(20, 227, 1, 3, 2, true, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(21, 228, 1, 3, 2, true, 2);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(22, 229, 1, 3, 2, true, 2);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(23, 230, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(24, 231, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(25, 232, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(26, 233, 1, 1, 2, true, 0);

-- Isolated Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(7, 440, 2, 1, 4, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(8, 441, 2, 1, 4, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(9, 442, 2, 1, 4, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(27, 443, 2, 1, 4, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(28, 444, 2, 1, 4, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(29, 445, 2, 1, 4, true, 0);

-- Intesive Care Section - ICU / CCU
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(10, 550, 3, 1, 5, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(11, 551, 3, 1, 5, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(12, 552, 3, 1, 5, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(13, 553, 3, 1, 5, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(30, 554, 1, 1, 1, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(31, 555, 1, 1, 1, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(32, 556, 2, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(33, 557, 2, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(34, 558, 1, 1, 1, true, 0);

INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(14, 554, 4, 1, 5, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(15, 555, 4, 2, 5, true, 1);

-- Operation Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(16, 330, 5, 1, 3, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(17, 331, 5, 1, 3, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(18, 332, 5, 1, 3, true, 0);
