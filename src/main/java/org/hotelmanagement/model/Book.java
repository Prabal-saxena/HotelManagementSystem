package org.hotelmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    private int book_id;
    @Column
    private String name;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String subCategory;
    @Column
    private String publisher;
    @Column
    private String language;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookItem> copies = new ArrayList<>();
}
