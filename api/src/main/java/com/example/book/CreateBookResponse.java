package com.example.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CreateBookResponse {

    @Schema(example = "1",
            description = "Unique book id in our service")
    private String id;

    @Schema(example = "War and Peace")
    private String title;

    @Schema(description = "Author list", example = "[\"Leo Tolstoy\"]")
    private List<String> authors;

    @Schema(example = "2008",
            description = "Book release date")
    private short year;

    @Schema(example = "978-1-85326-062-9",
            description = "The International Standard Book Number (ISBN) is a numeric commercial book identifier which is intended to be unique")
    private String isbn;
}
