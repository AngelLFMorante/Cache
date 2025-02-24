package org.afernandez.example.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Aplicación Spring Boot con soporte de caché.
 */
@SpringBootApplication
@EnableCaching // Habilita la funcionalidad de caché en Spring Boot
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }
}