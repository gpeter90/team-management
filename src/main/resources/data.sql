DROP TABLE IF EXISTS team;

CREATE TABLE team(
    id identity primary key unique,
    name varchar(45) unique,
    established varchar(4),
    no_championship_titles int,
    entry_fee tinyint
);

INSERT INTO team(name, established, no_championship_titles, entry_fee)
VALUES ('Ferrari', '1929', 16, 1),
       ('McLaren', '1963', 8, 0);