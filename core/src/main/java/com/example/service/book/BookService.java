package com.example.service.book;

import com.example.api.Book;
import com.example.db.book.BookEntity;

public interface BookService {

    Book getBook(Long id);

    BookEntity addBook(AddBookDto book);

    BookEntity editBook(BookEntity book);

    void deleteBook(Long id);

}
