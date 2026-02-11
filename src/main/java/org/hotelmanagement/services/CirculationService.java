package org.hotelmanagement.services;

import lombok.RequiredArgsConstructor;
import org.hotelmanagement.model.*;
import org.hotelmanagement.records.BookAvailableEvent;
import org.hotelmanagement.records.Money;
import org.hotelmanagement.repository.BookItemsRepository;
import org.hotelmanagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CirculationService {

    public static final int MAX_DAYS = 10;
    public static final int MAX_BOOKS = 5;

    private final FineService fineService;
    private final LoanRepository loanRepository;
    private final BookItemsRepository bookItemsRepository;

    private final ApplicationEventPublisher publisher;

    @Transactional
    public Loan checkout(Member member, BookItem bookItem){
        // validate if member eligibility
        validateCheckout(member, bookItem);

        bookItem.markLoaned();

        Loan loan = new Loan(LocalDate.now(), null, LocalDate.now().plusDays(MAX_DAYS), bookItem, member.getId());

        return loanRepository.save(loan);
    }

    @Transactional
    public Money returnBook(BookItem bookItem){
        Loan activeLoan = loanRepository.findByBookItemAndReturnDtIsNull(bookItem).orElseThrow(() -> new RuntimeException("No Active Loan found"));

        BookItem item = activeLoan.getBookItem();
        item.markAvailable();
        bookItemsRepository.save(item);

        Money fine = fineService.calculateFine(activeLoan);
        activeLoan.setFine(fine.amount());

        publisher.publishEvent(new BookAvailableEvent(item.getBook()));
        return fine;
    }

    private void validateCheckout(Member member, BookItem bookItems){

        int activeLoans = loanRepository.findByMemberIdAndReturnDtIsNull(member).size();

        if(activeLoans >= MAX_BOOKS)
            throw new RuntimeException("Exceeds the loan limit.");

        if(bookItems.getStatus() != BookStatus.AVAILABLE)
            throw new RuntimeException("Book not available.");
    }
}
