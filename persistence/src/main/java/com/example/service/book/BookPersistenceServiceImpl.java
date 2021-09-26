package com.example.service.book;

import com.example.api.Book;
import com.example.db.author.AuthorEntity;
import com.example.db.author.AuthorsRepo;
import com.example.db.book.BookEntity;
import com.example.db.book.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Validator;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Validated
class BookPersistenceServiceImpl implements BookPersistenceService {

    private BookRepo bookRepo;
    private AuthorsRepo authorsRepo;
    private Validator validator;
    private BookMapper bookMapper;


    @Override
    public Book add(AddBookDto book) throws BookNotFoundException {
        var a = validator.validate(book);
        var authorsIdSet = book.getAuthors().stream().map(it -> Long.parseLong(it.getId())).collect(Collectors.toSet());
        var authorsSet = new HashSet<>(authorsRepo.findAllById(authorsIdSet));

        BookEntity bookEntity = bookMapper.toEntity(book);
        bookEntity.setAuthors(authorsSet);
        var saved = bookRepo.save(bookEntity);

        return bookMapper.toApi(saved);
    }

    @Override
    public Book get(Book book) throws BookNotFoundException, NullPointerException {
        return null;
    }

    @Override
    public Book get(String id) throws BookNotFoundException, NullPointerException {
        long bookId = getBookId(id);
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

    private Long getBookId(String id) throws BookNotFoundException {
        long bookId;

        try {
            bookId = Long.parseLong(id);
        }
        catch (NumberFormatException ex) {
            throw new BookNotFoundException(id);
        }

        return bookId;
    }

}
