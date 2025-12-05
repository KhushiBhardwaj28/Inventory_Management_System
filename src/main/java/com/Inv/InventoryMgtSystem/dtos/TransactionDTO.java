package com.Inv.InventoryMgtSystem.dtos;

import com.Inv.InventoryMgtSystem.enums.TransactionStatus;
import com.Inv.InventoryMgtSystem.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {

    private Long id;
    private Integer totalProducts;
    private Double totalPrice;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private String description;
    private String note;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    // Foreign Key IDs
    private Long productId;
    private Long userId;
    private Long supplierId;
}