package com.booking_reservation.service;

import com.booking_reservation.model.BookReservation;
import com.booking_reservation.repository.BookReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookReservationService {
    @Autowired
    private BookReservationRepository bookReservationRepository;
    public List<BookReservation> findAll() {
        return bookReservationRepository.findAllByStatus("Active");
    }

    public BookReservation save(BookReservation bookReservation) {
        bookReservation.setStatus("Active");
        bookReservation.setCreatedAt(new Date());
        bookReservation.setId(UUID.randomUUID().toString());
        return bookReservationRepository.save(bookReservation);
    }

    public BookReservation update(BookReservation bookReservation) {
        bookReservation.setCreatedAt(new Date());
        bookReservation.setReturn_date(new Date());
        return bookReservationRepository.save(bookReservation);
    }

    public BookReservation returnBook(String id) {
        Optional<BookReservation> bookReservation = bookReservationRepository.findById(id);
        if (bookReservation.isPresent()) {
            BookReservation bookReservation1 = bookReservation.get();
            bookReservation1.setReturn_date(new Date());
            return bookReservationRepository.save(bookReservation1);
        }else {
            return null;
        }
    }

//    public BookReservation notification(BookReservation bookReservation) {
//        return bookReservationRepository.findById(bookReservation.getId()).get();
//    }
}
