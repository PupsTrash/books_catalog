package com.example.service.book;

import com.example.service.constraint.ValidAuthorId;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Use this DTO for add new book
 */
@Value
@Valid
public class AddBookDto {

    @NotNull
    String title;

    @NotNull
    String isbn;

    @NotNull
    Short year;

    @Size(min = 1)
    @Valid
    Set<Author> authors;

    @Value
    @NotNull
    public static class Author {

        @NotNull
        @Min(1)
        @ValidAuthorId
        String id;
    }
}
