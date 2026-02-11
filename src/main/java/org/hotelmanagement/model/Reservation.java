package org.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column
    private LocalDate reservationDt;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public Reservation(Member member, Book book, LocalDate reservationDt, ReservationStatus status) {
        this.memberId = member;
        this.book = book;
        this.reservationDt = reservationDt;
        this.status = status;
    }
}
