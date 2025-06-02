package com.booking_reservation.controllers;

import com.booking_reservation.model.BookReservation;
import com.booking_reservation.service.BookReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-reservation")
@Tag(name = "Book API", description = "Operations related to books")
@Validated
public class BookReservationController {
    @Autowired
    private BookReservationService bookReservationService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/get")
    public ResponseEntity<List<BookReservation>> getBooks() {
        return new ResponseEntity<>(bookReservationService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BookReservation> createBook(@Valid @RequestBody BookReservation bookReservation) {
        return new ResponseEntity<>(bookReservationService.save(bookReservation), HttpStatus.CREATED);
    }

    @PostMapping("/return-booking/{id}")
    public ResponseEntity<String> returnBooking(@PathVariable String id) {
        bookReservationService.returnBook(id);
        return new ResponseEntity<>("Book has been returned.", HttpStatus.OK);
    }

}
