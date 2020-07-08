package com.example.LoanWebApp.service;

import com.example.LoanWebApp.dao.LoanDao;
import com.example.LoanWebApp.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoanService {

    private final LoanDao loanDao;

    @Autowired
    public LoanService(@Qualifier("postgres") LoanDao loanDao) {
        this.loanDao = loanDao;
    }

    public int addLoan(Loan loan) {
        return loanDao.insertNewLoan(loan);
    }

    public List<Loan> getAllLoans() {
        return loanDao.selectAllLoans();
    }

    public Optional<Loan> getLoanById(UUID id) {
        return loanDao.selectLoanById(id);
    }

    public int deleteLoanById(UUID id) {
        return loanDao.deleteLoanById(id);
    }

    public int updateLoanById(UUID id, Loan newLoan) {
        return loanDao.updateLoanById(id, newLoan);
    }

    public int payLoanMonthlyRate(UUID id){
        return loanDao.payLoanMonthlyRate(id);
    }
}
