
create table if not exists product
(
    id          bigint,
    title       varchar(50)       not null,
    description varchar(50)       not null,
    price       integer           not null,
    store_id    integer default 1 not null
    );

alter table product
    owner to mike;