package com.example.testspring;

import com.example.testspring.infra.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePokemonUseCase {
    final PokemonRepository pokemonRepository;

    public CreatePokemonUseCase(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon execute(String name, String type) {
        Pokemon pokemon = PokemonFactory.create(name, type);
        this.pokemonRepository.save(pokemon);
        return pokemon;
    }
}
