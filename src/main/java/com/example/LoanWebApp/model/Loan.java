package com.example.LoanWebApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Loan {
    private final UUID idLoan;
    private final String nameLoanHolder;
    private double amountBorrowed;
    private double monthlyInterestRate;
    private int months;
    private double rateAmount;
    private double amountToRepay;

    public Loan(@JsonProperty("idLoan") UUID idLoan,@JsonProperty("nameLoanHolder") String nameLoanHolder,@JsonProperty("amountBorrowed") double amountBorrowed,
                @JsonProperty("monthlyInterestRate") double monthlyInterestRate,@JsonProperty("months") int months) {
        this.idLoan = idLoan;
        this.nameLoanHolder = nameLoanHolder;
        this.amountBorrowed = amountBorrowed;
        this.monthlyInterestRate = monthlyInterestRate / 100;
        this.months = months;
        this.rateAmount = calculateMonthlyRate();
        this.amountToRepay = calculateAmountToRepay();
    }

    public UUID getIdLoan() {
        return idLoan;
    }

    public String getNameLoanHolder() {
        return nameLoanHolder;
    }

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public int getMonths() {
        return months;
    }

    private double calculateMonthlyRate() {
        return ((amountBorrowed * monthlyInterestRate * months) + amountBorrowed) / months;
    }

    private double calculateAmountToRepay() {
        return (amountBorrowed * monthlyInterestRate * months) + amountBorrowed;
    }

    public double payMonthlyRate() {
        this.months -= 1;
        return this.amountToRepay -= rateAmount;
    }

    public double getAmountToRepay() {
        return Math.round(amountToRepay * 100.0) / 100.0;
    }


}
