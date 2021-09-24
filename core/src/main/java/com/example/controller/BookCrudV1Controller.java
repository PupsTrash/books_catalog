package com.example.controller;

import com.example.book.*;
import com.example.common.PageableResponse;
import com.example.common.PageableSize;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookCrudV1Controller implements BooksV1CrudApi {

    @Override
    public BookResponse getBookById(String id) {
        return null;
    }

    @Override
    public BookResponse createBook(BookRequest request) {
        return null;
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
