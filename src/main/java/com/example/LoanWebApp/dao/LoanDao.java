package com.example.LoanWebApp.dao;

import com.example.LoanWebApp.model.Loan;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanDao {

    int insertNewLoan(UUID id, Loan loan);

    default int insertNewLoan(Loan loan) {
        UUID id = UUID.randomUUID();
        return insertNewLoan(id, loan);
    }

    List<Loan> selectAllLoans ();

    Optional<Loan> selectLoanById(UUID id);

    int deleteLoanById(UUID id);

    int updateLoanById(UUID id, Loan newLoan);

    int payLoanMonthlyRate(UUID id);

}
