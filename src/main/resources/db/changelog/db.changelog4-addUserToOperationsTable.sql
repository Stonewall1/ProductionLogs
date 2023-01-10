--liquibase formatted sql

--changeset Stonewall:4

--comment: Altered Operations table , added User dependence

ALTER TABLE operations
    ADD user_id BIGINT,
    ADD CONSTRAINT operations_user_fk FOREIGN KEY (user_id) REFERENCES users (id)