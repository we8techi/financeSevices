package com.we8techi.platform.finance.controller;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.service.LoanTransactionsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/*
@RunWith(SpringRunner.class)
@WebMvcTest(LoanTransactionsController.class)
class LoanTransactionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanTransactionsService loanTransactionService;

    @Test
    public void testGetLoanTransactionById() throws Exception {
        // Create a sample LoanTransaction
        LoanTransactions loanTransaction = new LoanTransactions();
        loanTransaction.setId(1L);

        // Mock the service method
        when(loanTransactionService.getLoanTransactionById(1L)).thenReturn(loanTransaction);

        // Perform a GET request to the endpoint
        mockMvc.perform(get("/api/loan-transactions/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void createLoanTransaction() {
    }

    @Test
    void getLoanTransactionById() {
    }

    @Test
    void getAllLoanTransactions() {
    }

    @Test
    void updateLoanTransaction() {
    }

    @Test
    void deleteLoanTransaction() {
    }

    @Test
    void getLoanTransactionsByLoanAccountId() {
    }
}*/
