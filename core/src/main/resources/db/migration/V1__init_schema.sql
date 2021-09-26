CREATE SEQUENCE book_seq INCREMENT 1 START 1;

create table PUBLIC.book
(
    id    int8 default nextval('PUBLIC.book_seq') not null,
    title varchar (255),
    isbn varchar (50),
    year int,
    created_at timestamp with time zone default current_timestamp,
    updated_at timestamp with time zone,
    deleted_at timestamp with time zone,

    primary key (id)
);

CREATE SEQUENCE author_seq INCREMENT 1 START 1;

create table PUBLIC.author
(
    id    int8 default nextval('PUBLIC.author_seq') not null,
    first_and_second_name varchar (255) unique,

    primary key (id)
);


CREATE SEQUENCE book_author_seq INCREMENT 1 START 1;
create table PUBLIC.book_author
(
    id    int8 default nextval('PUBLIC.book_author_seq') not null,
    book_id int8 constraint book_author_book_id_fk references PUBLIC.book,
    author_id int8 constraint book_author_author_id_fk references PUBLIC.author,

    primary key (id)
);