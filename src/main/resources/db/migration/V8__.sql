CREATE TABLE product
(
    id        BIGINT         NOT NULL,
    name      VARCHAR(255)   NOT NULL,
    base_cost DECIMAL(19, 2) NOT NULL,
    image     OID,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE inventory_item
    ADD product_id BIGINT;

ALTER TABLE inventory_item
    ADD CONSTRAINT FK_INVENTORY_ITEM_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE inventory_item
    DROP CONSTRAINT fk_inventory_item_on_item_image;

DROP TABLE item_image CASCADE;

ALTER TABLE inventory_item
    DROP COLUMN base_cost;

ALTER TABLE inventory_item
    DROP COLUMN item_image_id;

ALTER TABLE inventory_item
    DROP COLUMN name;