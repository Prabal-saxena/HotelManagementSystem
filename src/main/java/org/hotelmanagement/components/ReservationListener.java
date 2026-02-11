package org.hotelmanagement.components;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.model.ReservationStatus;
import org.hotelmanagement.records.BookAvailableEvent;
import org.hotelmanagement.services.NotificationService;
import org.hotelmanagement.services.ReservationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationListener {

    private final ReservationService reservationService;
    private final NotificationService notificationService;

    @EventListener
    public void handle(BookAvailableEvent event){

        reservationService.nextReservation(event.book())
                .ifPresent(reservation -> {
                    notificationService.notify(reservation.getMemberId());
                    reservation.setStatus(ReservationStatus.NOTIFIED);
                });
    }
}
