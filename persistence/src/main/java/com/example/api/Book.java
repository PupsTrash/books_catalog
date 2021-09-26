package com.example.api;

import lombok.Value;

import java.time.OffsetDateTime;
import java.util.Set;

@Value
public class Book {

    Long id;

    String title;
    String isbn;
    Short year;

    Set<Author> authors;

    OffsetDateTime created_at;
    OffsetDateTime deleted_at;

}
