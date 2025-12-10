package com.Inv.InventoryMgtSystem.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StartupDataFixer {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void normalizeTransactionTypes() {
        try {
            int p = jdbcTemplate.update("UPDATE transactions SET transaction_type = 'PURCHASE' WHERE LOWER(transaction_type) = 'purchase'");
            int s = jdbcTemplate.update("UPDATE transactions SET transaction_type = 'SALE' WHERE LOWER(transaction_type) = 'sale'");
            int r = jdbcTemplate.update("UPDATE transactions SET transaction_type = 'RETURN_TO_SUPPLIER' WHERE REPLACE(LOWER(transaction_type),' ','_') = 'return_to_supplier'");
            log.info("Normalized transaction_type rows: PURCHASE={}, SALE={}, RETURN_TO_SUPPLIER={}", p, s, r);
        } catch (Exception e) {
            log.warn("Could not normalize transaction_type values: {}", e.getMessage());
        }
    }
}