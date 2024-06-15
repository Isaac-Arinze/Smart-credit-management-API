package com.Application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_limit")
public class CreditLimit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrower_id")
    private String borrowerId;

    @Column(name = "credit_limit")
    private double creditLimit;

    @Column(name = "used_amount")
    private double usedAmount;

    @Column(name = "remaining_amount")
    private double remainingAmount;

    public String getBorrowerId(){
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId){
        this.borrowerId = borrowerId;
    }

    public double getCreditLimit(){
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit){
        this.creditLimit = creditLimit;
    }

    public double getUsedAmount(){
        return usedAmount;
    }

    public void setUsedAmount(double usedAmount){
        this.usedAmount = usedAmount;
    }

    public double getRemainingAmount(){
        return creditLimit - usedAmount;
    }

    public void setRemainingAmount(double remainingAmount){
        this.remainingAmount = remainingAmount;
    }
}