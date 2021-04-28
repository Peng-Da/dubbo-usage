package com.singerdream.textdetection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultTransactionProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicBeans {

    @Bean
    public HikariDataSource hikariDataSource(@Value("${spring.datasource.url}")String url
            ,@Value("${spring.datasource.username}")String user,@Value("${spring.datasource.password}")String password) {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(10);//todo
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.setConnectionTestQuery("SELECT 1");
        config.addDataSourceProperty("url", url);
        config.addDataSourceProperty("user", user);
        config.addDataSourceProperty("password", password);
        config.setLeakDetectionThreshold(1000);//todo
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }


    @Bean
    public DefaultConfiguration configuration(HikariDataSource hikariDataSource) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.setDataSource(hikariDataSource);
        jooqConfiguration.setTransactionProvider(new DefaultTransactionProvider(new DataSourceConnectionProvider(hikariDataSource),true));
        jooqConfiguration.set(SQLDialect.POSTGRES);
        return jooqConfiguration;
    }
}
