ALTER TABLE product
    ADD description VARCHAR(255);

ALTER TABLE product
    ADD dtype VARCHAR(31);

ALTER TABLE product
    ADD max_play_time INTEGER;

ALTER TABLE product
    ADD max_players INTEGER;

ALTER TABLE product
    ADD min_age INTEGER;

ALTER TABLE product
    ADD min_payers INTEGER;

ALTER TABLE product
    ADD min_play_time INTEGER;

UPDATE product
SET DTYPE = 'Product'
WHERE DTYPE is null;