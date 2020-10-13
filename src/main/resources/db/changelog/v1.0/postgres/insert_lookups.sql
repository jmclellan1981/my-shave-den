INSERT INTO lookup_type(id, date_created, date_modified, type_name, type_description)
VALUES(uuid_generate_v4(), now(), now(), 'WEBSITE', 'Website featuring wet shave products');

INSERT INTO lookup_type(id, date_created, date_modified, type_name, type_description)
VALUES(uuid_generate_v4(), now(), now(), 'ITEM_TYPE', 'Category of product');

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'MAGGARDS', 'Maggards Razors', (SELECT id FROM lookup_type WHERE type_name='WEBSITE'));

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'SOAP', 'Shave Soap/Cream', (SELECT id FROM lookup_type WHERE type_name='ITEM_TYPE'));

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'BRUSH', 'Shave Brush', (SELECT id FROM lookup_type WHERE type_name='ITEM_TYPE'));

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'RAZOR', 'Razor', (SELECT id FROM lookup_type WHERE type_name='ITEM_TYPE'));

INSERT INTO lookup_data(id, date_created, date_modified, data_name, data_description, lookup_type_id)
VALUES(uuid_generate_v4(), now(), now(), 'BLADE', 'Razor Blade', (SELECT id FROM lookup_type WHERE type_name='ITEM_TYPE'));