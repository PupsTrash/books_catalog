package com.example.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Value;

import java.util.List;
import java.util.Set;

@Data
public class BookResponse {

    @Schema(example = "1",
            description = "Unique book id in our service")
    private String id;

    @Schema(example = "War and Peace")
    private String title;

    @Schema(description = "Author list", example = "[\"Leo Tolstoy\"]")
    private Set<AuthorResponse> authors;

    @Schema(example = "2008",
            description = "Book release date")
    private short year;

    @Schema(example = "978-1-85326-062-9",
            description = "The International Standard Book Number (ISBN) is a numeric commercial book identifier which is intended to be unique")
    private String isbn;

    @Value
    public static class AuthorResponse {
        String id;
        String name;
    }

}
