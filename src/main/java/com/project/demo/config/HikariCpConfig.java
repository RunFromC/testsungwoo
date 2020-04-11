package com.project.demo.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

@Configuration
public class HikariCpConfig {

    @Bean
    public HikariConfig hikariConfig() throws Exception {

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:hikari-cp-config.yml");
        Properties loadProperties = PropertiesLoaderUtils.loadProperties(resource);

        return new HikariConfig(loadProperties);
    }
}