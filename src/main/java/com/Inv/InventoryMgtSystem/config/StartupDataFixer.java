package com.Inv.InventoryMgtSystem.config;

import jakarta.annotation.PostConstruct;
import com.Inv.InventoryMgtSystem.enums.UserRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StartupDataFixer {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

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

    @PostConstruct
    public void ensureAdminUser() {
        try {
            String email = "admin_ims@gmail.com";
            String name = "Admin";
            String phone = "0000000000";
            String rawPassword = "Password@1234";
            Integer count = jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM users WHERE email = ?",
                    Integer.class,
                    email
            );
            if (count != null && count == 0) {
                String encoded = passwordEncoder.encode(rawPassword);
                // Postgres uses identity for ID; omit id in insert
                jdbcTemplate.update(
                        "INSERT INTO users (name, email, password, phone_number, role, Created_At) VALUES (?,?,?,?,?, NOW())",
                        name,
                        email,
                        encoded,
                        phone,
                        UserRole.ADMIN.name()
                );
                log.info("Seeded ADMIN user {}", email);
            } else {
                log.info("ADMIN user {} already exists", email);
            }
        } catch (Exception e) {
            log.warn("Could not seed admin user: {}", e.getMessage());
        }
    }
}