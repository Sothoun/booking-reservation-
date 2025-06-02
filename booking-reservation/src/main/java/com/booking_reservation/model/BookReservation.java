package com.booking_reservation.model;

import com.booking_reservation.config.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="tbl_book_reservation")
public class BookReservation extends BaseEntity {
    @Id
    private String id;
    @NotBlank
    @Column(name="user_id", nullable=false)
    private String user_id;
    @Column(name="book_id", nullable = false)
    private String book_id;
    @Column(name="during_reservation", nullable = false)
    private Integer during_reservation;
    @Column(name="is_return", nullable = false)
    private Boolean is_return;
    @Column(name="noted_date", nullable = true)
    private Date noted_date;
    @Column(name="return_date", nullable = true)
    private Date return_date;
}

