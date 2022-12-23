--liquibase formatted sql

--changeset Stonewall:2

--comment: R1 table created

CREATE TABLE r1
(
    id               SERIAL PRIMARY KEY,
    operation_start  TIMESTAMP(50),
    operation        varchar(512) NOT NULL,
    operation_finish TIMESTAMP(50)
);