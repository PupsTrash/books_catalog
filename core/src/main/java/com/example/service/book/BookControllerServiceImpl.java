package com.example.service.book;

import com.example.db.BookEntity;
import com.example.repositories.BookRepo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookControllerServiceImpl implements BookControllerService {
    private final BookRepo repo;

    @Override
    public BookEntity getBook(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public BookEntity addBook(String title, String author, String codeISBN, Short yearPublishing) {
        final var book = new BookEntity();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCodeISBN(codeISBN);
        book.setYearPublishing(yearPublishing);
        return repo.save(book);
    }

    @Override
    public BookEntity editBook(String title, String author, String codeISBN, Short yearPublishing, Long id) {
        final var book = new BookEntity();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCodeISBN(codeISBN);
        book.setYearPublishing(yearPublishing);
        book.setId(id);
        return repo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
