package com.project.demo.config;

import com.project.demo.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowCredentials(true)
                .allowedOrigins(
                        "http://127.0.0.1",
                        "http://127.0.0.1:8080",
                        "http://127.0.0.1:8081",

                        "http://192.168.0.31:8080",
                        "http://192.168.0.31:8081",
                        "http://192.168.0.31:8082",
                        "http://192.168.0.31:8083"
                );
    }
}