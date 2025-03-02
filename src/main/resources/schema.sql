DROP TABLE IF EXISTS todoitems;

CREATE TABLE todoitems(
    id INTEGER NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    status VARCHAR(10) NOT NULL,
    details VARCHAR(256) NOT NULL,
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);