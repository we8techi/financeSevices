package com.we8techi.platform.finance.service;

import com.we8techi.platform.finance.entity.LoanTransactions;
import com.we8techi.platform.finance.repository.LoanTransactionsRepository;
import com.we8techi.platform.finance.service.impl.LoanTransactionsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class LoanTransactionsServiceImplTest {

    @InjectMocks
    private LoanTransactionsServiceImpl loanTransactionService;

    @Mock
    private LoanTransactionsRepository loanTransactionRepository;

    @Test
    public void testCreateLoanTransaction() {
        // Create a sample LoanTransaction object
        LoanTransactions loanTransaction = new LoanTransactions();
        loanTransaction.setAmount(1000.0);

        // Mock the repository save method
        when(loanTransactionRepository.save(any())).thenReturn(loanTransaction);

        // Call the service method
        LoanTransactions savedTransaction = loanTransactionService.createLoanTransaction(loanTransaction);

        // Verify that the repository save method was called
        verify(loanTransactionRepository).save(loanTransaction);

        // Assert the result
        assertNotNull(savedTransaction);
        assertEquals(Double.valueOf(1000), savedTransaction.getAmount());
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

    @Test
    void getLoanTransactionsByPigmiId() {
    }
}