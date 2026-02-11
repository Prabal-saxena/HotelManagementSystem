package org.hotelmanagement.services;

import org.hotelmanagement.model.Loan;
import org.hotelmanagement.records.Money;
import org.springframework.stereotype.Service;

import static java.util.concurrent.TimeUnit.DAYS;

@Service
public class FineService {

    private static final double PER_DAY_FINE = 2.0;

    public Money calculateFine(Loan loan){
        if(loan.getReturnDt().isBefore(loan.getDueDt()))
            return new Money(0);

        long days = DAYS.toChronoUnit().between(loan.getDueDt(), loan.getReturnDt());

        return new Money(days * PER_DAY_FINE);
    }
}
