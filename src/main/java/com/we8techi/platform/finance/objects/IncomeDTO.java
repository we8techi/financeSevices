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
public class IncomeDTO {
    private Long id;
    private String source;
    private Double amount;
    private String receivingAccount;
    private String payerName;
    private LocalDate dateReceived;
    private String description;
    private String paymentMethod;
    private String currency;
    private String referenceNumber;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long companyId;
}
