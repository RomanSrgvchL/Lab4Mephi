--liquibase formatted sql

--changeset roman:insert-users
INSERT INTO "user" (first_name, last_name, role)
VALUES ('Иван', 'Сергеев', 'ADMIN'),
       ('Мария', 'Кузнецова', 'DEVELOPER'),
       ('Алексей', 'Смирнов', 'TESTER'),
       ('Екатерина', 'Соколова', 'SYSTEM_ANALYST'),
       ('Дмитрий', 'Орлов', 'TEAM_LEAD');