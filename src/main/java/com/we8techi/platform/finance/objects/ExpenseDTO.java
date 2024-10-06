package com.we8techi.platform.finance.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpenseDTO {
    private Long id;
    private String payeeName;
    private String payerAccount;
    private Double amount;
    private LocalDate dateSpent;
    private String description;
    private String paymentMethod;
    private String referenceNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

