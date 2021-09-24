package com.example.book;

import com.example.common.PageableResponse;
import com.example.common.PageableSize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(description = "Common CRUD operations with books", name = "Common books operations")
@RequestMapping(value = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface BooksV1CrudApi {

    @Operation(summary = "Get exist book from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book found",
                    content = @Content(schema = @Schema(implementation = BookResponse.class))),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("books/{id}")
    BookResponse getBookById(@PathVariable String id);


    @Operation(summary = "Add new book to database")
    @ApiResponse(responseCode = "200", description = "Book added successfully")
    @PostMapping("books")
    BookResponse createBook(@RequestBody BookRequest request);

    @Operation(summary = "Delete exist book from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("books/{id}")
    void deleteBook(@PathVariable String id);

    @Operation(summary = "Edit exist book database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book edited successfully"),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping("books/{id}")
    void editBook(@PathVariable String id, BookRequest request);

    @Operation(summary = "Find book by params")
    @GetMapping("/books")
    PageableResponse<BookResponse> getBooks(
            @ParameterObject FindBookRequest request,
            @ParameterObject PageableSize size,
            @ParameterObject BookSortParam sort);
}
