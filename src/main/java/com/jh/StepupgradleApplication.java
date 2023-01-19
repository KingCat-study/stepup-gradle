package com.jh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StepupgradleApplication {
    public static void main(String[] args) {
        SpringApplication.run(StepupgradleApplication.class, args);
    }
}
