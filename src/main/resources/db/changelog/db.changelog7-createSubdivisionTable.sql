--liquibase formatted sql

--changeset Stonewall:7

--comment: Subdivisions table created

CREATE TABLE subdivisions
(
    id               SERIAL PRIMARY KEY,
    subdivision_name varchar(512) NOT NULL
)
