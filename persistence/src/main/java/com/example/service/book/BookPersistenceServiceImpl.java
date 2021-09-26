package com.example.service.book;

import com.example.api.Book;
import com.example.db.AuthorsRepo;
import com.example.db.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
@Validated
public class BookPersistenceServiceImpl implements BookPersistenceService {

    private BookRepo bookRepo;
    private AuthorsRepo authorsRepo;
    private Validator validator;
    private BookMapper bookMapper;


    @Override
    public Book add(AddBookDto book) throws BookNotFoundException {
        var a = validator.validate(book);
        return null;
    }

    @Override
    public Book get(Book book) throws BookNotFoundException, NullPointerException {
        return null;
    }

    @Override
    public Book get(String id) throws BookNotFoundException, NullPointerException {
        long bookId;

        try {
            bookId = Long.parseLong(id);
        }
        catch (NumberFormatException ex) {
            throw new BookNotFoundException(id);
        }

        var entity = bookRepo.findNonDeletedBookById(bookId).orElseThrow(BookNotFoundException::new);

        return bookMapper.toApi(entity);
    }

    @Override
    public Book edit(Book book) throws BookNotFoundException, NullPointerException {
        return null;
    }

    @Override
    public void delete(String id) throws BookNotFoundException, NullPointerException {

    }
}
