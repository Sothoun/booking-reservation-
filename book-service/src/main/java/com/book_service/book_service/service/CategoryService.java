package com.book_service.book_service.service;

import com.book_service.book_service.model.Category;
import com.book_service.book_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> findAll() {
        return categoryRepository.findAllByStatus("Active");
    }

    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        category.setStatus("Active");
        category.setId(UUID.randomUUID().toString());
        category.setCreatedAt(new Date());
        return categoryRepository.save(category);
    }

    public Category update(Category category){
        category.setCreatedAt(new Date());
        return categoryRepository.save(category);
    }

    public Category delete(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        System.out.println(category.isPresent());
        if (category.isPresent()) {
            Category categoryToDelete = category.get();
            categoryToDelete.setStatus("DELETED");
            categoryRepository.save(categoryToDelete);
            return categoryToDelete;
        } else {
            return null;
        }
    }
}
