DROP TABLE IF EXISTS Product;

CREATE TABLE product
(
    id          bigint,
    title       VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    price       INTEGER     NOT NULL
);