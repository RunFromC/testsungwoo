package com.project.demo.config.datasource;

import com.zaxxer.hikari.HikariConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static com.project.demo.config.Utils.getConfiguredDataSource;
import static com.project.demo.config.Utils.getSqlSessionFactory;

@Slf4j
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "dohwanEntityManagerFactory",
        transactionManagerRef = "dohwanTransactionManager",
        basePackages = { "com.project.demo.repository.jpa.dohwan" }
)
@MapperScan(value = "com.project.demo.repository.mapper.dohwan", sqlSessionFactoryRef = "dohwanSqlSessionFactory")
public class DohwanDataSourceConfig {

    private final HikariConfig hikariConfig;

    public DohwanDataSourceConfig(HikariConfig hikariConfig) {
        this.hikariConfig = hikariConfig;
    }


    @Primary
    @Bean(name = "dohwanDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dohwan")
    public DataSource operatorDataSource() {
        return getConfiguredDataSource(hikariConfig, log, "dohwan");
    }

    @Bean(name = "dohwanEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dohwanDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.project.demo.domain")
                .persistenceUnit("dohwan")
                .build();
    }

    @Primary
    @Bean(name = "dohwanTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("dohwanEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Primary
    @Bean(name = "dohwanSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dohwanDataSource") DataSource dataSource) throws Exception {
        Resource[] arrResource = new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/dohwan/**/*Mapper.xml");

        return getSqlSessionFactory(dataSource, arrResource);
    }

    @Primary
    @Bean(name = "dohwanSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}