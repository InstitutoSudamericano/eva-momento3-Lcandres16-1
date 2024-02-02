CREATE TABLE IF NOT EXISTS film (
    id SERIAL,
    title VARCHAR(100),
    director VARCHAR(100),
    duration INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS scenes (
    id SERIAL,
    location VARCHAR(100),
    description VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES films(id),
    );
