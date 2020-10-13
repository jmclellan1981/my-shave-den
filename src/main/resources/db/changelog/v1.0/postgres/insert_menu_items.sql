INSERT INTO menu_item
(id, date_created, date_modified, action, title, path)
VALUES
(uuid_generate_v4(), now(), now(), null, 'My Wishlist', '/wishlist');

INSERT INTO menu_item
(id, date_created, date_modified, action, title, path)
VALUES
(uuid_generate_v4(), now(), now(), null, 'Forums', '/forums');