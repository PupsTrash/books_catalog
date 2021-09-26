package com.example.controller.book;

import com.example.api.Book;
import com.example.book.BookRequest;
import com.example.book.BookResponse;
import com.example.service.book.AddBookDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookResponseMapper {

    BookResponse toResponse(Book book);
    AddBookDto toDto(BookRequest request);
    AddBookDto.Author map(String id);

}
