--liquibase formatted sql

--changeset Stonewall:6

--comment: Altered Operations table , added Equipment dependence

ALTER TABLE operations
    ADD equipment_id BIGINT,
    ADD CONSTRAINT operations_equipment_fk FOREIGN KEY (equipment_id) REFERENCES equipment (id)