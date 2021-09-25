package com.example.service.book;

import com.example.book.BookRequest;
import com.example.book.BookResponse;
import com.example.db.AuthorEntity;
import com.example.db.BookEntity;
import com.example.repositories.AuthorsRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")

public abstract class BookMapper {
    @Autowired
    protected AuthorsRepo authorsRepo;

    @Mapping(target = "authors", source = "authors", qualifiedByName = "toResponseAuthors")
    public abstract BookResponse toResponse(BookEntity bookEntity);

    @Named("toResponseAuthors")
    public List<String> authors(Set<AuthorEntity> authorEntities) {
        return authorEntities.stream()
                .map(AuthorEntity::getFirst_and_second_name)
                .collect(Collectors.toList());
    }

    @Mapping(target = "authors", source = "authors", qualifiedByName = "toRequestAuthors")
    public abstract BookEntity toEntity(BookRequest request);

    @Named("toRequestAuthors")
    public Set<AuthorEntity> authorsEntity(List<String> authorRequest) {

        var all = authorsRepo.findAll();
        var otherAuthorsName = all.stream()
                .map(AuthorEntity::getFirst_and_second_name)
                .collect(Collectors.toList());

        otherAuthorsName.removeAll(authorRequest);

        var knownAuthors = all;
        knownAuthors.removeIf(p -> otherAuthorsName.contains(p.getFirst_and_second_name()));

        var unknownAuthorsName = authorRequest;
        unknownAuthorsName.removeIf(p ->
                knownAuthors.stream()
                        .map(AuthorEntity::getFirst_and_second_name)
                        .collect(Collectors.toList())
                        .contains(p));

        var authors = unknownAuthorsName.stream()
                .map(p -> new AuthorEntity(p))
                .collect(Collectors.toSet());

        authors.addAll(new HashSet<>(knownAuthors));
        return authors;
    }
}
