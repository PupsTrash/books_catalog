package com.example.service.book;

import com.example.api.Author;
import com.example.api.Book;
import com.example.db.AuthorEntity;
import com.example.db.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
interface BookMapper {

    Book toApi(BookEntity entity);

    @Mapping(target = "name", source = "first_and_second_name")
    Author toApi(AuthorEntity entity);
}
