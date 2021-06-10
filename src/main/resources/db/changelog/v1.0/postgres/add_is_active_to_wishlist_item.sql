ALTER TABLE wishlist_item ADD COLUMN is_active boolean;
UPDATE wishlist_item SET is_active = TRUE;
ALTER TABLE wishlist_item ALTER COLUMN is_active SET NOT NULL;