package com.example.service.book;

import com.example.api.Book;
import com.sun.istack.NotNull;

import javax.validation.Valid;

/**
 * This interface provided methods for working with database. Null objects not return.
 */
public interface BookPersistenceService {


    @NotNull Book add(@Valid AddBookDto book) throws BookNotFoundException;

    /**
     * Get book by params. If any param is null - it will be ignored
     * @param book
     * @return
     * @throws BookNotFoundException
     */
    @NotNull Book get(Book book) throws BookNotFoundException;

    /**
     * Get book by their ID.
     * @param id - id in our database
     * @return Book dto if book has been found
     * @throws BookNotFoundException if book can't be found
     */
    @NotNull Book get(@NotNull String id) throws BookNotFoundException;

    @NotNull Book edit(@NotNull Book book) throws BookNotFoundException;

    void delete(@NotNull String id) throws BookNotFoundException;
}
