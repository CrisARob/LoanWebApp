package com.example.LoanWebApp.dao;

import com.example.LoanWebApp.model.Loan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeLoanDataAccessService implements LoanDao{

    private static List<Loan> DB = new ArrayList<>();

    @Override
    public int insertNewLoan(UUID id, Loan loan) {
        DB.add(new Loan(id, loan.getNameLoanHolder(), loan.getAmountBorrowed(), loan.getMonthlyInterestRate(), loan.getMonths()));
        return 1;
    }

    @Override
    public List<Loan> selectAllLoans() {
        return DB;
    }

    @Override
    public Optional<Loan> selectLoanById(UUID id) {
        return DB.stream().filter(loan -> loan.getIdLoan().equals(id)).findFirst();
    }

    @Override
    public int deleteLoanById(UUID id) {
        Optional<Loan> loanMaybe = selectLoanById(id);
        if(loanMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(loanMaybe.get());
        return 1;
    }

    @Override
    public int updateLoanById(UUID id, Loan newLoan) {
        return selectLoanById(id).map(loan -> {int indexOfLoanToUpdate = DB.indexOf(loan);
        if(indexOfLoanToUpdate >= 0) {
            DB.set(indexOfLoanToUpdate, new Loan(id, newLoan.getNameLoanHolder(), newLoan.getAmountBorrowed(), newLoan.getMonthlyInterestRate(), newLoan.getMonths()));
        return 1;}
        return 0;}).orElse(0);
    }

    @Override
    public int payLoanMonthlyRate(UUID id) {
        return selectLoanById(id).map(loan -> {int indexOfLoanToUpdate = DB.indexOf(loan);
            if(indexOfLoanToUpdate >= 0) {
                Loan l = DB.set(indexOfLoanToUpdate, loan);
                l.payMonthlyRate();
                return 1;}
            return 0;}).orElse(0);
    }
}
