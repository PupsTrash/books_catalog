package com.example.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PageableSize {

    @Schema(example = "0", description = "Get specific page", defaultValue = "0")
    private Integer page = 0;

    @Schema(example = "10", description = "Response size", defaultValue = "10")
    private Integer size = 10;
}
