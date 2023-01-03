--liquibase formatted sql

--changeset Stonewall:3

--comment: Operations table created

CREATE TABLE operations
(
    id                    SERIAL PRIMARY KEY,
    operation_start       TIMESTAMP(50),
    operation_description varchar(512) NOT NULL,
    operation_finish      TIMESTAMP(50)
);