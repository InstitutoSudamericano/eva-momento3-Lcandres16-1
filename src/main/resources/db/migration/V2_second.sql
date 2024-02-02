CREATE TABLE IF NOT EXISTS character (
    id SERIAL,
    name VARCHAR(100),
    role VARCHAR(100),
    cost BIG DECIMAL(10,3)
    film_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (film_id) REFERENCES films(id)
    );