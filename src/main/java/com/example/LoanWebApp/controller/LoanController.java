package com.example.LoanWebApp.controller;

import com.example.LoanWebApp.model.Loan;
import com.example.LoanWebApp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/loan")
@RestController
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public void addNewLoan(@RequestBody Loan loan) {
        loanService.addLoan(loan);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return  loanService.getAllLoans();
    }

    @GetMapping(path = "{id}")
    public Loan getLoanById(@PathVariable("id")UUID id) {
        return loanService.getLoanById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteLoanById(@PathVariable("id") UUID id) {
        loanService.deleteLoanById(id);
    }

    @PutMapping(path = "{id}")
    public void updateLoanById(@PathVariable("id") UUID id, @RequestBody Loan loanToUpdate) {
        loanService.updateLoanById(id, loanToUpdate);
    }

    @PatchMapping(path = "{id}")
    public void payLoanMonthlyRate(@PathVariable("id") UUID id) {
        loanService.payLoanMonthlyRate(id);
    }
}
