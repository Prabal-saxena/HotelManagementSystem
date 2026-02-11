package org.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    private int id;
    @Column
    private LocalDate issueDt;
    @Column
    private LocalDate returnDt;
    @Column
    private LocalDate dueDt;

    @OneToOne(cascade = CascadeType.ALL)
    private BookItem bookItem;

    @Column
    private int memberId;
    @Column
    private double fine;

    public Loan(LocalDate issueDt, LocalDate returnDt, LocalDate dueDt, BookItem bookItem, int memberId) {
        this.issueDt = issueDt;
        this.returnDt = returnDt;
        this.dueDt = dueDt;
        this.bookItem = bookItem;
        this.memberId = memberId;
    }
}
