--liquibase formatted sql

--changeset Stonewall:8

--comment: Join subdivisions and users tables

create table subdivisions_users
(
    subdivision_id BIGINT NOT NULL
        CONSTRAINT subdivisions_users_fk
            REFERENCES subdivisions (id),
    user_id        BIGINT NOT NULL
        CONSTRAINT users_subdivisions_fk
            REFERENCES users (id)
);