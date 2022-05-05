package com.example.testspring.infra;

import com.example.testspring.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PokemonRepository extends JpaRepository<Pokemon, UUID> {}