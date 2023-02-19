DROP TABLE IF EXISTS Product;

create sequence devschema.seq_store_0001 START 1 INCREMENT 1;

CREATE TABLE product
(
    id          bigint,
    title       VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    price       INTEGER     NOT NULL
);