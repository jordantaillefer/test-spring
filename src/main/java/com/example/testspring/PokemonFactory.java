package com.example.testspring;

public class PokemonFactory {
    public static Pokemon create(String name, String type) {
        return new Pokemon(name, type);
    }
}
