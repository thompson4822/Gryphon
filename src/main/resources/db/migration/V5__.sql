ALTER TABLE person
    ADD credit_amount DECIMAL(19, 2);

ALTER TABLE person
    DROP CONSTRAINT fk_person_on_credit;

DROP TABLE credit CASCADE;

ALTER TABLE person
    DROP COLUMN credit_id;