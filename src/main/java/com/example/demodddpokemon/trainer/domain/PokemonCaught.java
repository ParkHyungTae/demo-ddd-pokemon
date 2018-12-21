package com.example.demodddpokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PokemonCaught {

    private int number;
    private String nickname;

    public PokemonCaught(int number, String nickname) {
        this.number = number;
        this.nickname = nickname;
    }

    public void changeNickname(String nickname) {
        this.nickname = nickname;
    }
}
