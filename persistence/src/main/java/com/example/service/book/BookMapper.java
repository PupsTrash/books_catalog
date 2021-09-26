package com.example.service.book;

import com.example.api.Author;
import com.example.api.Book;
import com.example.db.author.AuthorEntity;
import com.example.db.book.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
interface BookMapper {

    Book toApi(BookEntity entity);

    @Mapping(target = "name", source = "first_and_second_name")
    Author toApi(AuthorEntity entity);

    @Mapping(target = "authors", ignore = true)
    BookEntity toEntity(AddBookDto dto);
}
