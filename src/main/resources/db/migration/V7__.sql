CREATE TABLE credentials
(
    id       BIGINT       NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT pk_credentials PRIMARY KEY (id)
);

CREATE TABLE item_image
(
    id    BIGINT NOT NULL,
    image OID,
    CONSTRAINT pk_item_image PRIMARY KEY (id)
);

ALTER TABLE person
    ADD credentials_id BIGINT;

ALTER TABLE employee
    ADD hourly_rate DECIMAL(19, 2);

ALTER TABLE store
    ADD image OID;

ALTER TABLE inventory_item
    ADD item_image_id BIGINT;

ALTER TABLE credentials
    ADD CONSTRAINT uc_credentials_username UNIQUE (username);

ALTER TABLE inventory_item
    ADD CONSTRAINT FK_INVENTORY_ITEM_ON_ITEM_IMAGE FOREIGN KEY (item_image_id) REFERENCES item_image (id);

ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_CREDENTIALS FOREIGN KEY (credentials_id) REFERENCES credentials (id);

ALTER TABLE employee
    DROP CONSTRAINT uc_employee_username;

ALTER TABLE employee
    DROP COLUMN password;

ALTER TABLE employee
    DROP COLUMN username;

INSERT INTO role (id, name)
VALUES (1, 'Associate');

INSERT INTO role (id, name)
VALUES (2, 'Clerk');

INSERT INTO role (id, name)
VALUES (3, 'Manager');