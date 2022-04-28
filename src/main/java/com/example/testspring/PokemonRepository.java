package com.example.testspring;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {

}