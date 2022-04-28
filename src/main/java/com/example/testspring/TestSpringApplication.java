package com.example.testspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@SpringBootApplication
@RestController
public class TestSpringApplication {

    final CreatePokemonUseCase createPokemonUseCase;

    public TestSpringApplication(CreatePokemonUseCase createPokemonUseCase) {
        this.createPokemonUseCase = createPokemonUseCase;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TestSpringApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", System.getenv("PORT")));
        app.run(args);
    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        System.out.println(System.getenv("DATABASE_URL"));
        return String.format("Hello %s", name);
    }

    @PostMapping(value = "/pokemon", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = this.createPokemonUseCase.execute(pokemon.getName(), pokemon.getType());
        return String.format("created Pokemon %s, type: %s", createdPokemon.getName(), createdPokemon.getType());
    }
}
