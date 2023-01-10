--liquibase formatted sql

--changeset Stonewall:5

--comment: Altered Operations table , added Operation status dependence

ALTER TABLE operations
    ADD operation_status varchar(50)