package com.booking_reservation.repository;

import com.booking_reservation.model.BookReservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookReservationRepository extends CrudRepository<BookReservation, String> {
    List<BookReservation> findAllByStatus(String status);
}
