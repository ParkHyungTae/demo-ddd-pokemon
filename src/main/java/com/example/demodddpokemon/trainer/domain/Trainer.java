package com.example.demodddpokemon.trainer.domain;

public class Trainer {

    private String id;
    private int level;
    private Party party;

    public Trainer(String id) {
        this.id = id;
        this.level = 1;
        this.party = new Party();
    }

    public void levelUp() {
        if(this.level >= 30) {
            return;
        }

        this.level = this.level + 1;
    }

    public void gotPokemon(final PokemonCaught pokemonCaught) {
        this.party.add(pokemonCaught);
        this.levelUp();
    }

    public double getTrainerBonus() {
        if(this.level < 11) {
            return 1.0d;
        }

        return this.level / 10.0d;
    }
}
