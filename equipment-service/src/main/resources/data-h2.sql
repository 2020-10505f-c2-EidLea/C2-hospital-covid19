INSERT INTO TBL_PROVIDER (id, name, phone, email) values (1, 'Provider 1', '06890321', 'provider1@company.com');
INSERT INTO TBL_PROVIDER (id, name, phone, email) values (2, 'Provider 2', '05453381', 'provider2@company.com');
INSERT INTO TBL_PROVIDER (id, name, phone, email) values (3, 'Provider 3', '04947335', 'provider3@company.com');
INSERT INTO TBL_PROVIDER (id, name, phone, email) values (4, 'Provider 4', '01742586', 'provider4@company.com');
INSERT INTO TBL_PROVIDER (id, name, phone, email) values (5, 'Provider 5', '09964555', 'provider5@company.com');

INSERT INTO TBL_EQUIPMENT_TYPE (id, name, service_id, description) values (1, 'Respirator', 1, 'Respirator');
INSERT INTO TBL_EQUIPMENT_TYPE (id, name, service_id, description) values (2, 'PCR kit', 2, 'PCR kit');

INSERT INTO TBL_EQUIPMENT(id, id_type, provider_id, quantity, disponibility) values (1, 1, 1, 185, 170);
INSERT INTO TBL_EQUIPMENT(id, id_type, provider_id, quantity, disponibility) values (2, 1, 4, 35, 2);
INSERT INTO TBL_EQUIPMENT(id, id_type, provider_id, quantity, disponibility) values (3, 1, 5, 487, 0);
INSERT INTO TBL_EQUIPMENT(id, id_type, provider_id, quantity, disponibility) values (4, 2, 1, 347, 15);
