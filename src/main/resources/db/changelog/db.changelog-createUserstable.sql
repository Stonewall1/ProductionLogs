--liquibase formatted sql

--changeset Stonewall:1

--comment: Users table created

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    first_name varchar(50)  NOT NULL,
    last_name  varchar(512) NOT NULL
);