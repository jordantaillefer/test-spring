package com.example.testspring.application;

import com.example.testspring.CreatePokemonUseCase;
import com.example.testspring.Pokemon;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonController {

    final CreatePokemonUseCase createPokemonUseCase;

    public PokemonController(CreatePokemonUseCase createPokemonUseCase) {
        this.createPokemonUseCase = createPokemonUseCase;
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
