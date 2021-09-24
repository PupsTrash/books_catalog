package com.example.service.book;

import com.example.book.BookResponse;
import com.example.book.ErrorResponse;
import com.example.db.BookEntity;
import com.example.repositories.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@AllArgsConstructor
@Service
public class BookControllerServiceImpl implements BookControllerService {
    private final BookRepo repo;
    private final BookMapper mapper;

    @Override
    public BookResponse getBook(Long id) {
        var book = repo.findById(id).orElseThrow(); //need refactor
        var res = mapper.toResponse(book);
        return res;
    }

    @Override
    public BookEntity addBook(String title, String author, String codeISBN, Short yearPublishing) {
        final var book = new BookEntity();
        book.setTitle(title);
//        book.setAuthors(new HashSet<>());    //need edit
//        book.setISBN_code(codeISBN);
//        book.setYear_publishing(yearPublishing);
        return repo.save(book);
    }

    @Override
    public BookEntity editBook(String title, String author, String codeISBN, Short yearPublishing, Long id) {
        final var book = new BookEntity();
        book.setTitle(title);
//        book.setAuthors(new HashSet<>());    //need edit
//        book.setISBN_code(codeISBN);
//        book.setYear_publishing(yearPublishing);
//        book.setId(id);
        return repo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}
