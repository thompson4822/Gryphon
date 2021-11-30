CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE address
(
    id             BIGINT NOT NULL,
    address_line_1 VARCHAR(255),
    address_line_2 VARCHAR(255),
    city           VARCHAR(255),
    state          VARCHAR(2),
    zip_code       VARCHAR(13),
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE person
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    phone      VARCHAR(255),
    email      VARCHAR(255),
    address_id BIGINT,
    CONSTRAINT pk_person PRIMARY KEY (id)
);

ALTER TABLE person
    ADD CONSTRAINT FK_PERSON_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES address (id);