package com.example.service.book;

import com.example.api.Book;
import com.example.db.BookEntity;
import com.example.db.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookPersistenceService bookService;

    @Override
    public Book getBook(Long id) {
        return bookService.get(id.toString());
    }

    @Override
    public BookEntity addBook(AddBookDto book) {
        return null;
    }

    @Override
    public BookEntity editBook(BookEntity book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
