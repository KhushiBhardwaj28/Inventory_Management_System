package com.Inv.InventoryMgtSystem.models;

import com.Inv.InventoryMgtSystem.enums.TransactionStatus;
import com.Inv.InventoryMgtSystem.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
@Data
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_products")
    private Integer totalProducts;

    @Column(name = "total_price")
    private BigDecimal totalPrice; // ✅ FIX 1: Changed Double to BigDecimal

    @Convert(converter = com.Inv.InventoryMgtSystem.config.TransactionTypeConverter.class)
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status")
    private TransactionStatus status; // ✅ FIX 2: Renamed from transactionStatus to 'status'

    private String description;
    private String note;

    @Builder.Default
    @Column(name = "updated_at")
    private LocalDateTime updateAt = LocalDateTime.now(); // ✅ FIX 3: Renamed from updatedAt to 'updateAt'

    @Builder.Default
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", totalProducts=" + totalProducts +
                ", totalPrice=" + totalPrice +
                ", transactionType=" + transactionType +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", updateAt=" + updateAt +
                ", createdAt=" + createdAt +
                ", product=" + product +
                ", user=" + user +
                ", supplier=" + supplier +
                '}';
    }
}