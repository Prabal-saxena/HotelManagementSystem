package org.hotelmanagement.services;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.model.Book;
import org.hotelmanagement.model.Member;
import org.hotelmanagement.model.Reservation;
import org.hotelmanagement.model.ReservationStatus;
import org.hotelmanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    // TODO:
    /* reserve book method
       fetch next reservation
    */
    @Autowired
    ReservationRepository reservationRepository;

    public void reservation(Member member, Book book){
        Reservation reservation = new Reservation(member ,book, LocalDate.now(), ReservationStatus.WAITING);
        reservationRepository.save(reservation);
        member.getReservations().add(reservation);
    }

    public Optional<Reservation> nextReservation(Book book){
        return reservationRepository
                .findByBookAndStatusOrderByReservationDt(
                    book,
                    ReservationStatus.WAITING)
                .stream()
                .findFirst();
    }
}
