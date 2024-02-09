CREATE TABLE IF NOT EXISTS film (
    id SERIAL,
    title VARCHAR(100) NOT NULL,
    director VARCHAR(100) NOT NULL,
    minutes INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS scene (
    id SERIAL,
    description VARCHAR(100) NOT NULL,
    minutes INT NOT NULL,
    location VARCHAR(100) NOT NULL,
    budget NUMERIC,
    film_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES film(id)
);

CREATE TABLE IF NOT EXISTS character (
    id SERIAL,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL,
    cost NUMERIC,
    scene_id SERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (scene_id) REFERENCES scene(id)
);