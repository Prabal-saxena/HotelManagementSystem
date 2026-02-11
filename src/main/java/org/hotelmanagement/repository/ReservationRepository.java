package org.hotelmanagement.repository;

import org.hotelmanagement.model.Book;
import org.hotelmanagement.model.Reservation;
import org.hotelmanagement.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByBookAndStatusOrderByReservationDt(Book book, ReservationStatus status);
}
