package com.example.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PageableResponse<T> {

    @Schema(example = "1", description = "Total pages")
    private Long pages;

    @Schema(example = "10", description = "Total elements")
    private Long elements;

    @Schema(description = "Payload")
    private List<T> list;
}
