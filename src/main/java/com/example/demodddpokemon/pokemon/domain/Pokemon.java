package com.example.demodddpokemon.pokemon.domain;

public class Pokemon {

    private int number; // 식별자
    private String name;
    private String sprites;
    private int captureRate;

    public Pokemon(int number, String name, String sprites, int captureRate) {
        this.number = number;
        this.name = name;
        this.sprites = sprites;
        this.captureRate = captureRate;
    }

    public boolean isCaught(final double calculatedCaptureRate, final int number) {
        return number < calculatedCaptureRate;
    }
}
