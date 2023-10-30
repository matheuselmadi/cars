package com.ws.cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe de configuração para lidar com Cross-Origin Resource Sharing (CORS).
 */
@Configuration
public class CorsConfig {
    /**
     * Configuração para permitir solicitações de origens específicas.
     *
     * @return Configurador WebMvc para CORS.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://cars-fe.vercel.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}