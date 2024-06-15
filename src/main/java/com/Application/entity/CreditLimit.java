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

    @Column
    private double remainingAmount;

    public String getBorrowerId(){
        return borrowerId;
    }

    public void setBorrowerId(){
        this.borrowerId;
    }

    public double getCreditLimit(){
        return creditLimit;
    }
    public double getUsedAmount(){
        return usedAmount;
    }

    public void setUsedAmount(){
        this.usedAmount = usedAmount;
    }

    public double getRemainingAmount(){
        return remainingAmount;
    }

    public void setremainingAmount(){
        this.remainingAmount = remainingAmount;
    }
}
