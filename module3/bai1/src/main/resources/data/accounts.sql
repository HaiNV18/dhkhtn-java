CREATE TABLE accounts (
    id BIGINT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO accounts (id, username, password) VALUES (1, 'admin1', '1234');