DROP TABLE IF EXISTS devschema.product;
DROP SEQUENCE IF EXISTS devschema.seq_store_0001

create sequence devschema.seq_store_0001 START 1 INCREMENT 1;

CREATE TABLE devschema.product
(
    id          bigint,
    store_id     bigint,
    title       VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    price       INTEGER     NOT NULL
);