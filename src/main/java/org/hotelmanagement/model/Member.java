package org.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    @Id
    private int id;
    @Column
    private String name;
    @OneToMany(mappedBy = "memberId", cascade = CascadeType.ALL)
    private List<Loan> activeLoan = new ArrayList<>();
    @OneToMany(mappedBy = "memberId")
    private List<Reservation> reservations = new ArrayList<>();
}
