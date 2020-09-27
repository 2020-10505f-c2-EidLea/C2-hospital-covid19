<<<<<<< HEAD
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
=======
-- Insert unit classes
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(1, 'A', 1);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(2, 'B', 2);
INSERT INTO TBL_CLASSES (id, name, nbr_of_bed) VALUES(3, 'C', 3);

-- Insert units parent floors 
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(1, 1, 'Floor1', 'Laboratory');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(2, 2, 'Floor2', 'Quarantine Rooms');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(3, 3, 'Floor3', 'Operations Bloc');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(4, 4, 'Floor4', 'Isolated Section');
INSERT INTO TBL_FLOOR (id, nbr, bloc, specialization) VALUES(5, 5, 'Floor5', 'Intensive Care Section');

-- Insert unit types
INSERT INTO TBL_TYPES (id, name, description) VALUES(1, 'Normal', 'Normal reception unit'); -- class A /B /C
INSERT INTO TBL_TYPES (id, name, description) VALUES(2, 'Isolated', 'Isolated for low imunity patients'); -- class A
INSERT INTO TBL_TYPES (id, name, description) VALUES(3, 'ICU', 'Intensive Care Unit'); --class A
INSERT INTO TBL_TYPES (id, name, description) VALUES(4, 'CCU', 'Cardiac Care Unit'); --class A / B
INSERT INTO TBL_TYPES (id, name, description) VALUES(5, 'Operation', 'Operation Rooms'); --class A

-- Insert Quarantine Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(1, 20, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(2, 21, 1, 1, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(3, 22, 1, 2, 2, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(4, 23, 1, 2, 2, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(5, 24, 1, 2, 2, true, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(6, 25, 1, 3, 2, false, 3);

-- Insert Isolated Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(7, 40, 2, 1, 4, false, 1); 
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(8, 41, 2, 1, 4, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(9, 42, 2, 1, 4, true, 0);

-- Insert Intesive Care Section - ICU / CCU
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(10, 50, 3, 1, 5, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(11, 51, 3, 1, 5, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(12, 52, 3, 1, 5, false, 1);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(13, 53, 3, 1, 5, true, 0);

INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(14, 54, 4, 1, 5, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(15, 55, 4, 2, 5, true, 1);

-- Insert Operation Rooms
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(16, 30, 5, 1, 3, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(17, 31, 5, 1, 3, true, 0);
INSERT INTO TBL_ROOM (id, nbr, id_type, id_class, id_floor, available, nbr_reserved_beds) VALUES(18, 32, 5, 1, 3, true, 0);
>>>>>>> 843bce3a8594a0b515ebea54194158354a1d5ce2
