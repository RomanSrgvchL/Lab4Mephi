--liquibase formatted sql

--changeset roman:create-user-table
CREATE TABLE "user"
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name  VARCHAR(20) NOT NULL,
    role       VARCHAR(20) NOT NULL,
    CONSTRAINT chk_first_name_length CHECK (char_length(first_name) BETWEEN 3 AND 20),
    CONSTRAINT chk_last_name_length CHECK (char_length(last_name) BETWEEN 3 AND 20),
    CONSTRAINT chk_role_valid CHECK (role IN ('ADMIN', 'DEVELOPER', 'TESTER', 'SYSTEM_ANALYST', 'TEAM_LEAD'))
);