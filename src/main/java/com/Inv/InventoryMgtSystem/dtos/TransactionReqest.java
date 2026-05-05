package com.Inv.InventoryMgtSystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.Inv.InventoryMgtSystem.enums.TransactionStatus;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReqest {

    @Positive(message = "Product ID is required and must be positive")
    private Long productId;

    @Positive(message = "Quantity is required and must be positive")
    private Integer quantity;

    private Long supplierId;

    private String description;

    private String note;
}