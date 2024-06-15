package com.Application.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrower_id")
    private String borrowerId;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "loan_date")
    private LocalDate loanDate;

    @Column(name = "repayment_date")
    private LocalDate repaymentDate;

    @Column(name = "payment_status")
    private String paymentStatus;
    
    @Column(name = "paid_date")
    private LocalDate paidDate;

    public Loan (String borrowerId, double loanAmount, LocalDate loanDate, LocalDate repaymentDate, String paymentStatus, LocalDate paidDate){
                this.borrower_id = borrower_id;
                this.loanAmount = loanAmount;
                this.loanDate = loanDate;
                this.repaymentDate = repaymentDate;
                this.paymentStatus = paymentStatus;
                this.paidDate = paidDate;
    }

    public Loan (){
        
    }

    public Long getid(){
        return id;
    }
    public void setId(){
        this.id=id;
    }

    public String getBorrowerId(){
        return borrowerId;
    }

    public void setBorrowerId(){
        this.borrowerId = borrowerId;
    }
    public double getloanAmount(){
        return loanAmount;
    }

    public void setLoanAmount(){
        this.loanAmount = loanAmount;
    }

    public LocalDate getLoanDate(){
        return loanDate;
    }

    public void setLoanAmount(){
        this.loanDate = loanDate;
    }

    public LocalDate getRepaymentDate(){
        return repaymentDate;
    }

    public void setRepaymentDate(){
        this.repaymentDate = repaymentDate;
    }

    public String getPaymentStatus(){
        return paymentStatus;
    } 

    public void setPaymentstatus(){
        this.paymentStatus = paymentStatus;
    }

    public LocalDate getPaidDate(){
        return paidDate;
    }

    public LocalDate setPaidDate(){
        this.paidDate = paidDate;
    }
}

