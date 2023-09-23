package com.irene.ireneText;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	  @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.addAllowedOrigin("http://127.0.0.1:5500"); // 允许的前端源
	        config.addAllowedMethod("*"); // 允许所有HTTP方法
	        config.addAllowedHeader("*"); // 允许所有HTTP头部
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }
}
