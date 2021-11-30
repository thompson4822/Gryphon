CREATE TABLE credit
(
    id     BIGINT         NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    CONSTRAINT pk_credit PRIMARY KEY (id)
);

CREATE TABLE inventory_item
(
    id        BIGINT                      NOT NULL,
    store_id  BIGINT,
    name      VARCHAR(255)                NOT NULL,
    base_cost DECIMAL(19, 2)              NOT NULL,
    barcode   VARCHAR(255)                NOT NULL,
    tracked   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_inventory_item PRIMARY KEY (id)
);

CREATE TABLE store
(
    id             BIGINT NOT NULL,
    phone          VARCHAR(255),
    email          VARCHAR(255),
    website        VARCHAR(255),
    tax            DECIMAL(19, 2),
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    city           VARCHAR(255),
    state          VARCHAR(2),
    zip_code       VARCHAR(13),
    CONSTRAINT pk_store PRIMARY KEY (id)
);

ALTER TABLE person
    ADD address_line_1 VARCHAR(255);

ALTER TABLE person
    ADD address_line_2 VARCHAR(255);

ALTER TABLE person
    ADD city VARCHAR(255);

ALTER TABLE person
    ADD credit_id BIGINT;

ALTER TABLE person
    ADD state VARCHAR(2);

ALTER TABLE person
    ADD zip_code VARCHAR(13);

ALTER TABLE inventory_item
    ADD CONSTRAINT FK_INVENTORY_ITEM_ON_STORE FOREIGN KEY (store_id) REFERENCES store (id);

ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_CREDIT FOREIGN KEY (credit_id) REFERENCES credit (id);

ALTER TABLE person
    DROP CONSTRAINT fk_person_on_address;

DROP TABLE address CASCADE;

ALTER TABLE person
    DROP COLUMN address_id;