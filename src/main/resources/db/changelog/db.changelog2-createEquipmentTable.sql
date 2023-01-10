--liquibase formatted sql

--changeset Stonewall:2

--comment: Equipment table created

CREATE TABLE equipment
(
    id                    SERIAL PRIMARY KEY,
    equipment_name        varchar(512)  NOT NULL,
    equipment_description varchar(5000) NOT NULL
);