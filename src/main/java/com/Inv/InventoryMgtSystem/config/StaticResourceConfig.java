package com.Inv.InventoryMgtSystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Value("${frontend.image.directory}")
    private String imagesDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String location = imagesDir;
        if (!location.endsWith("/")) {
            location = location + "/";
        }
        // Map URLs like http://host:port/products/<filename> to the filesystem directory
        registry.addResourceHandler("/products/**")
                .addResourceLocations("file:" + location);
    }
}
