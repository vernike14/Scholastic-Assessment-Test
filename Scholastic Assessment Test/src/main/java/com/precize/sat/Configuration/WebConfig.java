package com.precize.sat.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    @Value("${spring.mvc.cors.allowed-origins}")
    private String allowedOrigins;

    @Value("${spring.mvc.cors.allowed-headers}")
    private String allowedHeaders;

    @Value("${spring.mvc.cors.allowed-methods}")
    private String allowedMethods;

    @Value("${spring.mvc.cors.allow-credentials}")
    private boolean allowCredentials;

    @Value("${spring.mvc.cors.max-age}")
    private long maxAge;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(allowCredentials);
        config.addAllowedOrigin(allowedOrigins);
        config.addAllowedHeader(allowedHeaders);
        config.addAllowedMethod(allowedMethods);
        config.setMaxAge(maxAge);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

