--liquibase formatted sql

--changeset Stonewall:7

--comment: Departments table created

CREATE TABLE departments
(
    id               SERIAL PRIMARY KEY,
    department_name varchar(512) NOT NULL
)
