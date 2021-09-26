package com.example.controller.book;

import com.example.api.Book;
import com.example.book.BookResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookResponseMapper {

    BookResponse toResponse(Book book);

}
