package com.example.controller.book;

import com.example.book.*;
import com.example.common.PageableResponse;
import com.example.common.PageableSize;
import com.example.service.book.BookControllerService;
import com.example.service.book.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookCrudV1Controller implements BooksV1CrudApi {
    private final BookControllerService service;
    private final BookMapper mapper;

    @Override
    public BookResponse getBookById(String id) {
        return mapper.toResponse(service.getBook(Long.parseLong(id)));
    }

    @Override
    public BookResponse createBook(BookRequest request) {
        return mapper.toResponse(service.addBook(mapper.toEntity(request)));
    }


    @Override
    public void deleteBook(String id) {

    }

    @Override
    public void editBook(String id, BookRequest request) {

    }

    @Override
    public PageableResponse<BookResponse> getBooks(FindBookRequest request, PageableSize size, BookSortParam sort) {
        return null;
    }

}
