package com.example.testspring.infra;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.testspring.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.UUID;

@DataJpaTest
public class PokemonRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void shoud_find_no_pokemons_if_repository_is_empty() {
        Iterable<Pokemon> pokemons = pokemonRepository.findAll();
        assertThat(pokemons).isEmpty();
    }

    @Test
    public void shoud_store_a_pokemon() {
        final UUID uuid = UUID.randomUUID();
        final String name = "bulbizarre";
        final String type = "plante";
        Pokemon pokemon = pokemonRepository.save(new Pokemon(uuid, name, type));
        assertThat(pokemon).hasFieldOrPropertyWithValue("id", uuid);
        assertThat(pokemon).hasFieldOrPropertyWithValue("name", name);
    }

    @Test
    public void should_find_all_tutorials() {
        Pokemon pokemon1 = new Pokemon(UUID.randomUUID(), "bulbizarre", "plante");
        entityManager.persist(pokemon1);
        Pokemon pokemon2 = new Pokemon(UUID.randomUUID(), "salamèche", "feu");
        entityManager.persist(pokemon2);
        Pokemon pokemon3 = new Pokemon(UUID.randomUUID(), "carapuce", "eau");
        entityManager.persist(pokemon3);
        Iterable<Pokemon> tutorials = pokemonRepository.findAll();
        assertThat(tutorials).hasSize(3).contains(pokemon1, pokemon2, pokemon3);
    }

}
