--liquibase formatted sql

--changeset Stonewall:4

--comment: Altered R1 table , added Operation status dependence

ALTER TABLE r1
    ADD operation_status varchar(50)
