package org.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = "book_items")
public class BookItem {

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public void markLoaned(){
        this.status = BookStatus.LOANED;
    }
    public void markAvailable(){
        this.status = BookStatus.AVAILABLE;
    }
}
