package com.Application.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.Repository.CreditLimitRepository;
import com.Application.Repository.LoanRepository;
import com.Application.Repository.PaymentTransactionRepository;
import com.Application.Service.LoanService;
import com.Application.entity.CreditLimit;
import com.Application.entity.Loan;
import com.Application.entity.LoanApplicationRequest;

import com.Application.entity.PaymentTransaction;
import com.Application.entity.RepaymentRequest;

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
      response.put("loan", loan); // Fixed the typo here
      return ResponseEntity.ok(response);
    } catch (Exception e) {
      Map<String, Object> response = new HashMap<>(); // Fixed the typo here
      response.put("success", false);
      response.put("message", e.getMessage());
      return ResponseEntity.badRequest().body(response);
    }
  }

  @GetMapping("/loans")
  public ResponseEntity<Object> viewAllLoans() {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for retrieving loan data");
    return ResponseEntity.ok(response);
  }

  @GetMapping("/loans/{loanId}")
  public ResponseEntity<Object> viewLoanById(@PathVariable("loanId") Long loanId) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for retrieving loan data using loan id");
    return ResponseEntity.ok(response);
  }

  @GetMapping("/loans/borrowers/{borrowerId}")
  public ResponseEntity<Object> viewLoansByBorrowerId(@PathVariable("borrowerId") String borrowerId) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for retrieving loan data using borrower id");
    return ResponseEntity.ok(response);
  }

  @GetMapping("/loans/creditlimit/{borrowerId}")
  public ResponseEntity<Object> viewCreditLimitByBorrowerId(@PathVariable("borrowerId") String borrowerId) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for retrieving credit limit data using borrower id");
    return ResponseEntity.ok(response);
  }

  @GetMapping("/loans/paymentdetails/{loanId}")
  public ResponseEntity<Object> getPaymentDetails(@PathVariable("loanId") Long loanId) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for payment transaction details retrieved successfully.");
    return ResponseEntity.ok(response);
  }

  @PostMapping("/loans/paymentdetails/{loanId}/repayment")
  public ResponseEntity<Object> repayLoan(@PathVariable("loanId") Long loanId, @RequestBody RepaymentRequest request) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    response.put("message", "Logic for repayment for the loan id.");
    return ResponseEntity.ok(response);
  }
}