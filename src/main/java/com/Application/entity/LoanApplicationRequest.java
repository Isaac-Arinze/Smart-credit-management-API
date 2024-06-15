package com.Application.entity;

public class LoanApplicationRequest {
    private String borrowerId;
    private double loanAmount;

    public String getBorrowerId(){
        return borrowerId;
    }
    public void setBorrowerId(){
        this.borrowerId = borrowerId;
    }

    public double getLoanAmount(){
        return borrowerId;
    }

    public double setLoanAmount(){
        this.loanAmount = loanAmount;
    }

    public LoanApplicationRequest (String borrowerId, double loanAmount){
        this.borrowerId=borrowerId;
        this.loanAmount=loanAmount;
    }
    public LoanApplicationRequest(){
        
    }


}


