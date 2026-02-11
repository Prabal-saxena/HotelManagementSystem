package org.hotelmanagement.services;

import org.hotelmanagement.model.Member;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notify(Member member) {
        System.out.println("Notification sent to " + member.getName());
    }
}
