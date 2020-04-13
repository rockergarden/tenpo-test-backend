package com.criverostenpo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.criverostenpo")
@SpringBootApplication
public class CriverostenpoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriverostenpoApiApplication.class, args);
    }
}
