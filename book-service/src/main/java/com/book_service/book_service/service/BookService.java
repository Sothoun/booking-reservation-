package com.book_service.book_service.service;


import com.book_service.book_service.model.Book;
import com.book_service.book_service.model.Category;
import com.book_service.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAllByStatus("Active");
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        book.setStatus("Active");
        book.setId(UUID.randomUUID().toString());
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    public Book update(Book book){
        book.setCreatedAt(new Date());
        return bookRepository.save(book);
    }

    public Book delete(String id) {
        Optional<Book> book = bookRepository.findById(id);
        System.out.println(book.isPresent());
        if (book.isPresent()) {
            Book bookToDelete = book.get();
            bookToDelete.setStatus("DELETED");
            bookRepository.save(bookToDelete);
            return bookToDelete;
        } else {
            return null;
        }
    }
}
