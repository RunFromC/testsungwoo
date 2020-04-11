package com.project.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Objects;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class Utils {

    public static SqlSessionFactory getSqlSessionFactory(DataSource dataSource, Resource[] mapperLocations)
            throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.project.demo.domain");

        Objects.requireNonNull(sqlSessionFactoryBean.getObject()).getConfiguration().setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.getObject().getConfiguration().setCallSettersOnNulls(true);

        return sqlSessionFactoryBean.getObject();
    }

    public static DataSource getConfiguredDataSource(HikariConfig hikariConfig, Logger log, String sourceName) {

        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setConnectionTestQuery(hikariConfig.getConnectionTestQuery());
        hikariDataSource.setIdleTimeout(hikariConfig.getIdleTimeout());
        hikariDataSource.setMinimumIdle(hikariConfig.getMinimumIdle());
        hikariDataSource.setMaxLifetime(hikariConfig.getMaxLifetime());
        hikariDataSource.setMaximumPoolSize(hikariConfig.getMaximumPoolSize());

        log.warn("[{}] getConnectionTestQuery :: {}", sourceName, hikariDataSource.getConnectionTestQuery());
        log.warn("[{}] getIdleTimeout :: {}", sourceName, hikariDataSource.getIdleTimeout());
        log.warn("[{}] getMaxLifetime :: {}", sourceName, hikariDataSource.getMaxLifetime());
        log.warn("[{}] getMinimumIdle :: {}", sourceName, hikariDataSource.getMinimumIdle());
        log.warn("[{}] getMaximumPoolSize :: {}", sourceName, hikariDataSource.getMaximumPoolSize());

        return hikariDataSource;
    }
}