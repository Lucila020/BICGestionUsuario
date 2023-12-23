package com.bci.api.user.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuracion de Headers CORS para consumo en ambientes no productivos
 */

@Configuration
public class CORSHeadersConfig {

    @Value("${api.cors.origins}")
    private String allowedOrigins;

    /**
     * @return {@link WebMvcConfigurer}
     */
    @Bean
    public WebMvcConfigurer corsHeadersConfigurer() {

        final String configuredOrigins = this.allowedOrigins;

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(configuredOrigins).allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH");
            }
        };

    }
}
