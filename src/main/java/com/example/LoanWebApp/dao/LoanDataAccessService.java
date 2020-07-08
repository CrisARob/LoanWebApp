package com.example.LoanWebApp.dao;

import com.example.LoanWebApp.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class LoanDataAccessService implements LoanDao {
    @Override
    public int insertNewLoan(UUID id, Loan loan) {
        return 0;
    }

    @Override
    public List<Loan> selectAllLoans() {
        return List.of(new Loan(UUID.randomUUID(), "FROM POSTGRES DB", 0, 0, 0));
    }

    @Override
    public Optional<Loan> selectLoanById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteLoanById(UUID id) {
        return 0;
    }

    @Override
    public int updateLoanById(UUID id, Loan newLoan) {
        return 0;
    }

    @Override
    public int payLoanMonthlyRate(UUID id) {
        return 0;
    }
}
