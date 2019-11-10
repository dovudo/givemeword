create table first_names
(
    id         integer not null
        constraint first_names_pkey
            primary key,
    first_name varchar(255)
);

create table last_names
(
    id        integer not null
        constraint last_names_pkey
            primary key,
    last_name varchar(255)
);

create table words
(
    id     integer not null
        constraint words_pkey
            primary key,
    length integer not null,
    word   varchar(255)
);
