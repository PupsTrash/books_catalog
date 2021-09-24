package com.example.service.book;

import com.example.book.BookResponse;
import com.example.db.AuthorEntity;
import com.example.db.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Mapping(target = "authors", source = "authors", qualifiedByName = "authors")
    public abstract BookResponse toResponse(BookEntity bookEntity);

    @Named("authors")
    public List<String> authors(Set<AuthorEntity> authorEntities){
        return authorEntities.stream()
                .map(p -> new StringBuffer()
                                .append(p.getFirst_name())
                                .append(" ")
                                .append(p.getSecond_name()).toString())
                .collect(Collectors.toList());
    }
}
