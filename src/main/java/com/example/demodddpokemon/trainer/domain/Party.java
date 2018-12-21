package com.example.demodddpokemon.trainer.domain;

import java.util.ArrayList;
import java.util.List;

public class Party {
    private List<PokemonCaught> pokemons;

    public boolean isEmpty() {
        return (this.pokemons == null || this.pokemons.isEmpty());
    }

    public void add(final PokemonCaught pokemonCaught) {
        if(isEmpty()) {
            this.pokemons = new ArrayList<>();
        }

        this.pokemons.add(pokemonCaught);
    }
}
