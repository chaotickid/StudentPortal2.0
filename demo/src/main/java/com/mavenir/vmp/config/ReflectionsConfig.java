/**
 * Copyright © 2024 Mavenir Systems
 */
package com.mavenir.vmp.config;

/***
 * @author Aditya Patil
 * @date 12-12-2024
 */
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReflectionsConfig {

    @Bean
    public Reflections reflections() {
        return new Reflections("com.mavenir.vmp"); // Use your package name here
    }
}
