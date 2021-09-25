package com.example.service.book;

import com.example.book.BookResponse;
import com.example.db.BookEntity;

public interface BookControllerService {


    BookEntity getBook(Long id);

    BookEntity addBook(BookEntity book);

    BookEntity editBook(BookEntity book);

    void deleteBook(Long id);

}
