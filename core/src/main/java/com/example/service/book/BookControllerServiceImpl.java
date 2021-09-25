package com.example.service.book;

import com.example.db.BookEntity;
import com.example.repositories.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class BookControllerServiceImpl implements BookControllerService {
    private final BookRepo repo;


    @Override
    public BookEntity getBook(Long id) {
        var book = repo.findById(id).orElseThrow(); //need refactor
        return book;
    }

    @Override
    public BookEntity addBook(BookEntity book) {
        return repo.save(book);
    }

    @Override
    public BookEntity editBook(BookEntity book) {
        return repo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
