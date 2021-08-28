create TABLE IF NOT EXISTS users (
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL,
    email       TEXT NOT NULL,
    password    TEXT NOT NULL
);

create TABLE IF NOT EXISTS item (
    id          SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    user_id     int references users(id),
    created     TIMESTAMP,
    done        TEXT
);

