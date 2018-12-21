package com.example.demodddpokemon.pokemon.domain;

public interface PokemonRepository {

    Pokemon findByNumber(int number);
}
