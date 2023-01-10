--liquibase formatted sql

--changeset Stonewall:8

--comment: Join departments and users tables

CREATE TABLE department_users
(
    department_id BIGINT NOT NULL
        CONSTRAINT departments_users_fk
            REFERENCES departments (id),
    user_id       BIGINT NOT NULL
        CONSTRAINT users_departments_fk
            REFERENCES users (id)
);