package com.employ.process.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.employ"})
@EntityScan(basePackages = {"com.employ.app.entity"})
@EnableJpaRepositories(basePackages = {"com.employ.process.app.repository"})
public class EmployProcessComponentApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployProcessComponentApplication.class, args);
    }
}
