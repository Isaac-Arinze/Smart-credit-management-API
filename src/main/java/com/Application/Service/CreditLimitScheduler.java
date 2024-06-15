package com.Application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Application.Repository.LoanRepository;
import com.Application.Repository.CreditLimitRepository;
import com.Application.entity.Loan;
import com.Application.entity.CreditLimit;

@Service
public class CreditLimitScheduler {

    @Autowired
    private LoanService loanService;

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CreditLimitRepository creditLimitRepository;

    // Schedule the method to run at regular intervals
    @Scheduled(cron = "0 0 0 1 * ?") // Runs at midnight on the first day of every month
    public void scheduleCreditLimitUpdate() {
        // Get all loans
        List<Loan> loans = loanRepository.findAll();
        
        // Iterate over each loan
        for (Loan loan : loans) {
            // Get the borrower's credit limit
            Optional<CreditLimit> creditLimitOptional = creditLimitRepository.findByBorrowerId(loan.getBorrowerId());
            if (creditLimitOptional.isPresent()) {
                CreditLimit creditLimit = creditLimitOptional.get();
                
                // Update the credit limit based on the loan status
                if (loan.getPaymentStatus().equals("Paid")) {
                    creditLimit.setUsedAmount(creditLimit.getUsedAmount() - loan.getLoanAmount());
                } else if (loan.getPaymentStatus().equals("Not Paid")) {
                    creditLimit.setUsedAmount(creditLimit.getUsedAmount() + loan.getLoanAmount());
                }
                
                // Save the updated credit limit
                creditLimitRepository.save(creditLimit);
            }
        }
    }
}