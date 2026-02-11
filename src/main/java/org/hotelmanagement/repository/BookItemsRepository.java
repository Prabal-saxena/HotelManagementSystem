package org.hotelmanagement.repository;

import org.hotelmanagement.model.BookItem;
import org.hotelmanagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookItemsRepository extends JpaRepository<BookItem, Long> {
}
