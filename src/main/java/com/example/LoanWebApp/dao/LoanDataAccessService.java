package com.example.LoanWebApp.dao;

import com.example.LoanWebApp.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class LoanDataAccessService implements LoanDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoanDataAccessService (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertNewLoan(UUID id, Loan loan) {
        final String sql = "INSERT INTO loan (idLoan, nameloanholder, amountborrowed, monthlyinterestrate, months) VALUES (uuid_generate_v4(), \'"+ loan.getNameLoanHolder() +
                "\', \'"+ loan.getAmountBorrowed() +"\', \'"+ loan.getMonthlyInterestRate() +"\', \'"+ loan.getMonths() +"\')";
        jdbcTemplate.execute(sql);
        return 1;
    }

    @Override
    public List<Loan> selectAllLoans(){
        final String sql = "SELECT idLoan, nameloanholder, amountborrowed, monthlyinterestrate, months FROM loan";
        List<Loan> loans = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("idLoan"));
            String name = resultSet.getString("nameloanholder");
            double amount = resultSet.getDouble("amountborrowed");
            double interest = resultSet.getDouble("monthlyinterestrate");
            int months = resultSet.getInt("months");
            return new Loan(id, name, amount, interest, months);
        });
        return loans;
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
