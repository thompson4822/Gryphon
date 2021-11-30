CREATE TABLE payment
(
    id                  BIGINT                      NOT NULL,
    amount              DECIMAL(19, 2)              NOT NULL,
    date_paid           TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    credit_card_info_id BIGINT,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE payment_type
(
    id   BIGINT       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_payment_type PRIMARY KEY (id)
);

CREATE TABLE rental
(
    id                BIGINT                      NOT NULL,
    inventory_item_id BIGINT                      NOT NULL,
    person_id         BIGINT                      NOT NULL,
    rental_date       TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    due_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    return_date       TIMESTAMP WITHOUT TIME ZONE,
    credit_amount     DECIMAL(19, 2),
    tax               DECIMAL(19, 2),
    subtotal          DECIMAL(19, 2),
    CONSTRAINT pk_rental PRIMARY KEY (id)
);

CREATE TABLE rental_feedback
(
    id        BIGINT  NOT NULL,
    rental_id BIGINT  NOT NULL,
    rating    INTEGER NOT NULL,
    other     VARCHAR(255),
    CONSTRAINT pk_rental_feedback PRIMARY KEY (id)
);

CREATE TABLE return
(
    id       BIGINT NOT NULL,
    store_id BIGINT,
    CONSTRAINT pk_return PRIMARY KEY (id)
);

ALTER TABLE payment_type
    ADD CONSTRAINT uc_payment_type_name UNIQUE (name);

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_CREDIT_CARD_INFO FOREIGN KEY (credit_card_info_id) REFERENCES credit_card_info (id);

ALTER TABLE rental_feedback
    ADD CONSTRAINT FK_RENTAL_FEEDBACK_ON_RENTAL FOREIGN KEY (rental_id) REFERENCES rental (id);

ALTER TABLE rental
    ADD CONSTRAINT FK_RENTAL_ON_INVENTORY_ITEM FOREIGN KEY (inventory_item_id) REFERENCES inventory_item (id);

ALTER TABLE rental
    ADD CONSTRAINT FK_RENTAL_ON_PERSON FOREIGN KEY (person_id) REFERENCES person (id);

ALTER TABLE return
    ADD CONSTRAINT FK_RETURN_ON_STORE FOREIGN KEY (store_id) REFERENCES store (id);