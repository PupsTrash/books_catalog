insert into PUBLIC.book (title, isbn, year)
values ('Anna Karenina', '978-1-84749-059-9', '1878'),
       ('The Great Gatsby', '0684801523', '1925'),
       ('The Great Anna Gatsby', '00000', '2021');

insert into PUBLIC.author(first_and_second_name)
values ('Leo Tolstoy'),
       ('Francis Scott Key Fitzgerald');

insert into PUBLIC.book_author (book_id, author_id)
values (1, 1),
       (3,1),
       (3,2),
       (2, 2);

