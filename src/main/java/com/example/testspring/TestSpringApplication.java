package com.example.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collections;

@SpringBootApplication
public class TestSpringApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestSpringApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", System.getenv("PORT")));
        app.run(args);
    }
}
