package com.book_service.book_service.repository;

import com.book_service.book_service.model.Book;
import com.book_service.book_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findAll();
    List<Book> findAllByStatus(String status);
}
