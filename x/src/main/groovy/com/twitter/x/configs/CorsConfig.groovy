//package com.twitter.x.configs
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//class CorsConfig {
//
//    @Bean
//    static CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration()
//        configuration.addAllowedOrigin("*")
//        configuration.addAllowedMethod("*")
//        configuration.addAllowedHeader("*")
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }
//}
