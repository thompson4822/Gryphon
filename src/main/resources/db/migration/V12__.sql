ALTER TABLE inventory_item
    DROP CONSTRAINT fk_inventory_item_on_inventory_item_type;

ALTER TABLE inventory_item_type
    DROP CONSTRAINT uc_inventory_item_type_name;

DROP TABLE inventory_item_type CASCADE;

ALTER TABLE inventory_item
    DROP COLUMN inventory_item_type_id;