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
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDTO {

    private Long id;
    private Integer totalProducts;
    private BigDecimal totalPrice;
    private TransactionType transactionType;
    private TransactionStatus status;
    private String description;
    private String note;
    private LocalDateTime updateAt;
    private LocalDateTime createdAt;

    private Long productId;
    private Long userId;
    private Long supplierId;

    private ProductDTO product;
    private UserDTO user;
    private SupplierDTO supplier;
}