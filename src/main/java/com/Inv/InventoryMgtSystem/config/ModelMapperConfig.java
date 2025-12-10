package com.Inv.InventoryMgtSystem.config;

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
                .setCollectionsMergeEnabled(false);

        // Remove custom type map skips to avoid configuration conflicts.
        // If needed, handle nested associations at service/DTO level explicitly.

        return modelMapper;
    }

}
