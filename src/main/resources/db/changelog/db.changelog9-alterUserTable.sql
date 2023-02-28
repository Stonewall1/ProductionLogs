--liquibase formatted sql

--changeset Stonewall:9

--comment: Added password , username and Role to user

ALTER TABLE users
    ADD username      varchar(512),
    ADD user_password varchar(512);


CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL
        CONSTRAINT user_roles_fk
            REFERENCES users (id),
    roles   varchar(512)
)
