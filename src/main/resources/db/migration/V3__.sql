CREATE TABLE credit_card_info
(
    id         BIGINT       NOT NULL,
    number     VARCHAR(255) NOT NULL,
    expiration date,
    person_id  BIGINT       NOT NULL,
    CONSTRAINT pk_credit_card_info PRIMARY KEY (id)
);

CREATE TABLE employee
(
    id        BIGINT                      NOT NULL,
    ssn       VARCHAR(255),
    username  VARCHAR(255)                NOT NULL,
    password  VARCHAR(255)                NOT NULL,
    hire_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    exit_date TIMESTAMP WITHOUT TIME ZONE,
    person_id BIGINT,
    store_id  BIGINT,
    role_id   BIGINT                      NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);

CREATE TABLE inventory_item_type
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_inventory_item_type PRIMARY KEY (id)
);

CREATE TABLE inventory_transfer
(
    id            BIGINT                      NOT NULL,
    store_from_id BIGINT                      NOT NULL,
    store_to_id   BIGINT                      NOT NULL,
    transfer_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_inventory_transfer PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE transfer_record
(
    id                    BIGINT NOT NULL,
    inventory_transfer_id BIGINT NOT NULL,
    inventory_item_id     BIGINT NOT NULL,
    CONSTRAINT pk_transfer_record PRIMARY KEY (id)
);

ALTER TABLE inventory_item
    ADD inventory_item_type_id BIGINT;

ALTER TABLE inventory_item
    ALTER COLUMN inventory_item_type_id SET NOT NULL;

ALTER TABLE credit_card_info
    ADD CONSTRAINT uc_credit_card_info_number UNIQUE (number);

ALTER TABLE employee
    ADD CONSTRAINT uc_employee_username UNIQUE (username);

ALTER TABLE inventory_item_type
    ADD CONSTRAINT uc_inventory_item_type_name UNIQUE (name);

ALTER TABLE role
    ADD CONSTRAINT uc_role_name UNIQUE (name);

ALTER TABLE credit_card_info
    ADD CONSTRAINT FK_CREDIT_CARD_INFO_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_ROLE FOREIGN KEY (role_id) REFERENCES role (id);

ALTER TABLE employee
    ADD CONSTRAINT FK_EMPLOYEE_ON_STORE FOREIGN KEY (store_id) REFERENCES store (id);

ALTER TABLE inventory_item
    ADD CONSTRAINT FK_INVENTORY_ITEM_ON_INVENTORY_ITEM_TYPE FOREIGN KEY (inventory_item_type_id) REFERENCES inventory_item_type (id);

ALTER TABLE inventory_transfer
    ADD CONSTRAINT FK_INVENTORY_TRANSFER_ON_STORE_FROM FOREIGN KEY (store_from_id) REFERENCES store (id);

ALTER TABLE inventory_transfer
    ADD CONSTRAINT FK_INVENTORY_TRANSFER_ON_STORE_TO FOREIGN KEY (store_to_id) REFERENCES store (id);

ALTER TABLE transfer_record
    ADD CONSTRAINT FK_TRANSFER_RECORD_ON_INVENTORY_ITEM FOREIGN KEY (inventory_item_id) REFERENCES inventory_item (id);

ALTER TABLE transfer_record
    ADD CONSTRAINT FK_TRANSFER_RECORD_ON_INVENTORY_TRANSFER FOREIGN KEY (inventory_transfer_id) REFERENCES inventory_transfer (id);