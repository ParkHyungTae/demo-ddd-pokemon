package com.example.demodddpokemon.pokemon.infra;

import com.example.demodddpokemon.pokemon.domain.Pokemon;
import com.example.demodddpokemon.pokemon.domain.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.Name;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;

public class PokeApiCall implements PokemonRepository {
    @Override
    public Pokemon findByNumber(int number) {
        final int KO_ID = 3;

        final PokeApi pokeApi = new PokeApiClient();

        final PokemonSpecies pokemonSpecies = pokeApi.getPokemonSpecies(number);
        final String pokemonName = pokemonSpecies.getNames()
                                                 .stream()
                                                 .filter(name -> name.getLanguage().getId() == KO_ID)
                                                 .findFirst()
                                                 .map(Name::getName)
                                                 .get();
        final int captureRate = pokemonSpecies.getCaptureRate();
        final String url = pokeApi.getPokemon(number).getSprites().getFrontDefault();

        return new Pokemon(number, pokemonName, url, captureRate);
    }
}
