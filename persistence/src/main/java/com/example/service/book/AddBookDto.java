package com.example.service.book;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Use this DTO for add new book
 */
@Value
public class AddBookDto {

    @NotNull
    String title;

    @NotNull
    String isbn;

    @NotNull
    Short year;

    @Size(min = 1)
    Set<Author> authors;

    @Value
    @NotNull
    static class Author {

        @NotNull
        @Min(2)
        String name;
    }
}
