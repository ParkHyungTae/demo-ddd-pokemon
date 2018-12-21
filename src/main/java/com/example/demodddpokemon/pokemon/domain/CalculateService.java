package com.example.demodddpokemon.pokemon.domain;

import com.example.demodddpokemon.pokeball.domain.PokeBall;
import com.example.demodddpokemon.trainer.domain.Trainer;

public class CalculateService {

    /**
     * 포획률 = (포켓몬의 포획률 * 몬스터볼 보정 승수 * (레벨 11 이상의 트레이너 레벨 / 10)) * 100 / 255
     * @param trainer
     * @param pokemon
     * @param pokeBall
     * @return double
     */
    public double calculatedCaptureRate(final Trainer trainer, final Pokemon pokemon, final PokeBall pokeBall) {
        final double calculatedCaptureRate = (pokemon.getCaptureRate() * pokeBall.getBonusMultiplier() * (trainer.getTrainerBonus() / 10)) * 100 / 255;

        final double maxPercent = 100.0d;

        if(calculatedCaptureRate < maxPercent) {
            return calculatedCaptureRate;
        }

        return maxPercent;
    }
}
