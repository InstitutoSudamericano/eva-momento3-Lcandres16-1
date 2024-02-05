CREATE TABLE IF NOT EXISTS film (
    id SERIAL,
    title VARCHAR(100) NOT NULL,
    director VARCHAR(100) NOT NULL,
    duration NUMERIC NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL,
    description VARCHAR(100) NOT NULL,
    duration NUMERIC NOT NULL,
    location VARCHAR(100) NOT NULL,
    film_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE IF NOT EXISTS character (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL,
    cost DECIMAL(10,3),
    film_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
);