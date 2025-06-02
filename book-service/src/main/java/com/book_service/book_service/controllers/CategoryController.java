package com.book_service.book_service.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.book_service.book_service.model.Category;
import com.book_service.book_service.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Book API", description = "Operations related to books")
@Validated
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get")
    @Operation(summary = "Get All Category", description = "")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new Category", description = "")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Specific Category", description = "")
    public ResponseEntity<Category> getCategory(@PathVariable String id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    @Operation(summary = "Update Category", description = "")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.update(category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Category", description = "")
    public ResponseEntity<Category> deleteCategory(@PathVariable String id) {
        categoryService.delete(id);
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }
}
