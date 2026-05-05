package com.Inv.InventoryMgtSystem.config;

import com.Inv.InventoryMgtSystem.dtos.TransactionDTO;
import com.Inv.InventoryMgtSystem.models.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Base configuration
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true)
            .setCollectionsMergeEnabled(false)
            .setPreferNestedProperties(false);

        // Explicit mapping for Transaction -> TransactionDTO with empty type map first
        modelMapper.createTypeMap(Transaction.class, TransactionDTO.class);
        modelMapper.typeMap(Transaction.class, TransactionDTO.class).addMappings(mapper -> {
            mapper.skip(TransactionDTO::setProduct);
            mapper.skip(TransactionDTO::setUser);
            mapper.skip(TransactionDTO::setSupplier);
            mapper.map(src -> src.getProduct() != null ? src.getProduct().getId() : null, TransactionDTO::setProductId);
            mapper.map(src -> src.getUser() != null ? src.getUser().getId() : null, TransactionDTO::setUserId);
            mapper.map(src -> src.getSupplier() != null ? src.getSupplier().getId() : null, TransactionDTO::setSupplierId);
        });

        return modelMapper;
    }

}
