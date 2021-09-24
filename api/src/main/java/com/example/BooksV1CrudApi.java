package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/")
public interface BooksV1CrudApi {

    @GetMapping("books/{id}")
    BookResponse getBookById(@PathVariable String id);
}
