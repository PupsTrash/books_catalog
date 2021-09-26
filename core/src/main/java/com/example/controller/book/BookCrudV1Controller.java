package com.example.controller.book;

import com.example.book.*;
import com.example.common.PageableResponse;
import com.example.common.PageableSize;
import com.example.service.book.BookPersistenceService;
import com.example.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookCrudV1Controller implements BooksV1CrudApi {
    private final BookService service;
    private final BookResponseMapper mapper;
    private final BookPersistenceService service2;

    @Override
    public BookResponse getBookById(String id) {
        var book = service.getBook(Long.parseLong(id));
        return mapper.toResponse(book);
    }

    @Override
    public BookResponse createBook(BookRequest request) {
        var dto = mapper.toDto(request);
        var response = service2.add(dto);
        return mapper.toResponse(response);
    }


    @Override
    public void deleteBook(String id) {
        //TODO: NEED IMPL
    }

    @Override
    public void editBook(String id, BookRequest request) {
        //TODO: NEED IMPL
    }

    @Override
    public PageableResponse<BookResponse> getBooks(FindBookRequest request, PageableSize size, BookSortParam sort) {
        //TODO: NEED IMPL
        return null;
    }

}
