package com.example.book;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookSortParam {

    @Schema(example = "id,title", description = "Sort by field")
    private String sort;
}
