CREATE SEQUENCE book_seq INCREMENT 1 START 1;

create table PUBLIC.book
(
    id    int8 default nextval('PUBLIC.book_seq') not null,
    title varchar (255),
    author varchar (255),
    ISBN_code varchar (50),
    year_publishing int,
    created_at timestamp with time zone default current_timestamp,

    primary key (id)
)