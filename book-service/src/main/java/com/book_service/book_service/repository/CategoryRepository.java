package com.book_service.book_service.repository;

import com.book_service.book_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    List<Category> findAll();
    List<Category> findAllByStatus(String status);
}
