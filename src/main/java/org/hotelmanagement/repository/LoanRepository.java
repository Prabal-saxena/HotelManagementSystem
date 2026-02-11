package org.hotelmanagement.repository;

import org.hotelmanagement.model.BookItem;
import org.hotelmanagement.model.Loan;
import org.hotelmanagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberIdAndReturnDtIsNull(Member member);

    Optional<Loan> findByBookItemAndReturnDtIsNull(BookItem item);
}
