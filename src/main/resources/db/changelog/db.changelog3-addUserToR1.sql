--liquibase formatted sql

--changeset Stonewall:3

--comment: Altered R1 table , added User dependence

ALTER TABLE r1
    ADD user_id BIGINT,
    ADD CONSTRAINT r1_user_fk FOREIGN KEY (user_id) REFERENCES users (id)
