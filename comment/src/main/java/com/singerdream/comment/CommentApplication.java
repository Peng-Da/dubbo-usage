package com.singerdream.comment;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.singerdream.comment.service")
@PropertySource(value = "classpath:/application.yml")
public class CommentApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(CommentApplication.class,args);
        Flyway.configure().dataSource(context.getBean(HikariDataSource.class)).load().migrate();
    }
}
