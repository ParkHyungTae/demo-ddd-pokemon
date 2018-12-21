package com.example.demodddpokemon.pokemon.application;

import com.example.demodddpokemon.pokeball.domain.PokeBall;
import com.example.demodddpokemon.pokeball.domain.PokeBallRepository;
import com.example.demodddpokemon.pokemon.domain.CalculateService;
import com.example.demodddpokemon.pokemon.domain.Pokemon;
import com.example.demodddpokemon.pokemon.domain.PokemonRepository;
import com.example.demodddpokemon.trainer.domain.PokemonCaught;
import com.example.demodddpokemon.trainer.domain.Trainer;
import com.example.demodddpokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class CatchingService {
    private TrainerRepository trainerRepository;

    private PokemonRepository pokemonRepository;

    private PokeBallRepository pokeBallRepository;

    public CatchingService(TrainerRepository trainerRepository,
                           PokemonRepository pokemonRepository,
                           PokeBallRepository pokeBallRepository) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokeBallRepository = pokeBallRepository;
    }

    @Transactional
    public boolean tryCatching(final String trainderId, final int pokemonNumber, final int pokeBallId) {
        final Trainer trainer = trainerRepository.findById(trainderId);
        final Pokemon pokemon = pokemonRepository.findByNumber(pokemonNumber);
        final PokeBall pokeBall = pokeBallRepository.findById(pokeBallId).orElse(null);

        final CalculateService calculateService = new CalculateService();
        final double calculatedCaptureRate = calculateService.calculatedCaptureRate(trainer, pokemon, pokeBall);

        final boolean caught = pokemon.isCaught(calculatedCaptureRate, new Random().nextInt(99));

        if(caught) {
            trainer.gotPokemon(new PokemonCaught(pokemon.getNumber(), pokemon.getName()));
        }

        return caught;
    }
}
