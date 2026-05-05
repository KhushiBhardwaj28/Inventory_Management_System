package com.Inv.InventoryMgtSystem.config;

import com.Inv.InventoryMgtSystem.enums.TransactionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class TransactionTypeConverter implements AttributeConverter<TransactionType, String> {
    @Override
    public String convertToDatabaseColumn(TransactionType attribute) {
        return attribute == null ? null : attribute.name();
    }

    @Override
    public TransactionType convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        String normalized = dbData.trim().toUpperCase().replace(' ', '_');
        // Handle common variants
        if ("PURCHASE".equals(normalized)) return TransactionType.PURCHASE;
        if ("SALE".equals(normalized)) return TransactionType.SALE;
        if ("RETURN_TO_SUPPLIER".equals(normalized) || "RETURN-T0-SUPPLIER".equals(normalized)) return TransactionType.RETURN_TO_SUPPLIER;
        // Fallback to enum value to surface unexpected ones
        return TransactionType.valueOf(normalized);
    }
}