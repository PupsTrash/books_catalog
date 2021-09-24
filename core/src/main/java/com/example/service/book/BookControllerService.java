package com.example.service.book;

import com.example.db.BookEntity;

public interface BookControllerService {


    BookEntity getBook(Long id);

    BookEntity addBook(String title, String author, String codeISBN, Short yearPublishing);

    BookEntity editBook(String title, String author, String codeISBN, Short yearPublishing, Long id);

    void deleteBook(Long id);

}
