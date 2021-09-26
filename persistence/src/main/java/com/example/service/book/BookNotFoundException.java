package com.example.service.book;


import javax.persistence.PersistenceException;

public class BookNotFoundException extends PersistenceException {

    private static final String defaultMessage = "Book with ID %s is not null";

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String id) {
        super(String.format(defaultMessage, id));
    }
}
