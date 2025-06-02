package com.book_service.book_service.controllers;

import com.book_service.book_service.model.Book;
import com.book_service.book_service.model.Category;
import com.book_service.book_service.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/books")
@Tag(name = "Book API", description = "Operations related to books")
@Validated
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/get")
    @Operation(summary = "Get All Books", description = "")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Specific Books", description = "")
    public ResponseEntity<?> getBookById(@PathVariable String id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(summary = "Add new Books", description = "")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Operation(summary = "Update Books", description = "")
    public ResponseEntity<?> updateBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.update(book), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Specific Book", description = "")
    public ResponseEntity<?> delete(@PathVariable String id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
