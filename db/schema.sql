CREATE TABLE item (
    id          SERIAL PRIMARY KEY,
    description VARCHAR(2000),
    created     TIMESTAMP,
    done        BOOLEAN
);