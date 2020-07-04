DROP TABLE IF EXISTS person;

CREATE TABLE person(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar not null,
    email varchar not null
);

INSERT INTO person(name,email) VALUES
('Danilo C. Graciano','danilocgraciano@gmail.com'),
('Jhon Doe','jhon@gmail.com');