package com.Inv.InventoryMgtSystem.dtos;

import com.Inv.InventoryMgtSystem.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private UserRole role;
    private LocalDateTime createdAt;
    // Note: Transactions list and password are intentionally omitted for security and simplicity
}