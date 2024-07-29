package com.Application.controller;

import com.Application.Service.LoanService;
import com.Application.entity.Loan;
import com.Application.entity.LoanApplicationRequest;
import com.Application.entity.RepaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/process")
    public ResponseEntity<Object> applyLoan(@RequestBody LoanApplicationRequest request) {
        try {
            Loan loan = loanService.applyLoan(request.getBorrowerId(), request.getLoanAmount());
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("loan", loan);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping()
    public ResponseEntity<Object> viewAllLoans() {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retrieving loan data");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Object> viewLoanById(@PathVariable("loanId") Long loanId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retrieving loan data using loan id");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/borrowers/{borrowerId}")
    public ResponseEntity<Object> viewLoansByBorrowerId(@PathVariable("borrowerId") String borrowerId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retrieving loan data using borrower id");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/creditlimit/{borrowerId}")
    public ResponseEntity<Object> viewCreditLimitByBorrowerId(@PathVariable("borrowerId") String borrowerId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for retrieving credit limit data using borrower id");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/paymentdetails/{loanId}")
    public ResponseEntity<Object> getPaymentDetails(@PathVariable("loanId") Long loanId) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for payment transaction details retrieved successfully.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/paymentdetails/{loanId}/repayment")
    public ResponseEntity<Object> repayLoan(@PathVariable("loanId") Long loanId, @RequestBody RepaymentRequest request) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Logic for repayment for the loan id.");
        return ResponseEntity.ok(response);
    }
}