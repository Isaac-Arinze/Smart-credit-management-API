package com.Application.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Application.Repository.CreditLimitRepository;
import com.Application.Repository.LoanRepository;
import com.Application.entity.CreditLimit;
import com.Application.entity.Loan;
import com.Application.entity.LoanApplicationRequest;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CreditLimitRepository creditLimitRepository;

    public Loan applyLoan(String borrowerId, double loanAmount) throws Exception{
        if (borrowerId == null || borrowerId.isEmpty() || loanAmount <=0){
            throw new IllegalArgumentException("Invalid loan application request");

        }
        CreditLimit creditlimit = creditLimitRepository.findByBorrowerId(borrowerId).orElseGet(
            () -> {
                CreditLimit newCreditLimit = new CreditLimit();
                newCreditLimit.setBorrowerId(borrowerId);
                newCreditLimit.setCreditLimit(5000.0);
                newCreditLimit.setUsedAmount(0.0);
                return newCreditLimit;
            });
        double remainingCreditLimit = creditlimit.getCreditLimit() - creditlimit.getUsedAmount();
        List<Loan> existingLoan = loanRepository.findByBorrowerIdAndPaymentStatus(borrowerId, "Not paid");

        for (Loan loan : existingLoan){
            if (loan.getRepaymentDate().isBefore(LocalDate.now())) {
                throw new Exception("Existing unpaid loans with crossed repayment date");
            }
        }
        if (loanAmount > remainingCreditLimit){
            throw new Exception("Loan Amount exceeds remaining credit limit");
        }
        
        Loan newLoan = new Loan();
        newLoan.setBorrowerId(borrowerId);
        newLoan.setLoanAmount(loanAmount);
        newLoan.setLoanDate(LocalDate.now());
        newLoan.setRepaymentDate(LocalDate.now().plusMonths(1));
        newLoan.setPaymentStatus("Not paid");

        loanRepository.save(newLoan);

        creditlimit.setUsedAmount(creditlimit.getUsedAmount() + loanAmount);
        creditLimitRepository.save(creditlimit);

        return newLoan;
    }
}