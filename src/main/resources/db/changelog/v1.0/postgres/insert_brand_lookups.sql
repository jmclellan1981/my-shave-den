INSERT INTO lookup_type(id, date_created, date_modified, type_name, type_description)
VALUES(uuid_generate_v4(), now(), now(), 'BRAND', 'Brand that produces shave products');

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'ABBATE_LA_MANTIA', 'Abbate Y La Mantia', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'ACH_BRITO', 'Ach Brito Creams and Soaps', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'ACQUA_DI_PARMA', 'Acqua di Parma', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'ARIANA_EVANS', 'Ariana and Evans', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'ARKO', 'Arko', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'BARRISTER_MANN', 'Barrister and Mann', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'BAUME_BE', 'Baume.BE', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'BLACK_SHIP', 'Black Ship Grooming Co.', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CAPTAINS_CHOICE', 'Captains\'s Choice', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CASTLE_FORBES', 'Castle Forbes Shaving Creams', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CATIES_BUBBLES', 'Catie\'s Bubbles Shaving Soaps', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CELLA', 'Cella', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CHICAGO_GROOMING', 'Chicago Grooming Co.', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CHISELED_FACE', 'Chiseled Face Shaving Soaps', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'COL_CONK', 'Col Conk Soaps & Creams', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'CROWN', 'Crown Shaving Co.', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'DECLARATION', 'Declaration Grooming', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'DERBY', 'Derby', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'DR_HARRIS', 'DR Harris Soaps & Creams', (SELECT id FROM lookup_type WHERE type_name='BRAND'));
