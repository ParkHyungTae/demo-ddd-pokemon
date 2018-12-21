package com.example.demodddpokemon.pokemon.application;

import com.example.demodddpokemon.pokeball.domain.PokeBall;
import com.example.demodddpokemon.pokeball.domain.PokeBallRepository;
import com.example.demodddpokemon.pokemon.domain.Pokemon;
import com.example.demodddpokemon.pokemon.domain.PokemonRepository;
import com.example.demodddpokemon.trainer.domain.Trainer;
import com.example.demodddpokemon.trainer.domain.TrainerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CatchingServiceTest {

    @InjectMocks
    private CatchingService catchingService;

    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private PokeBallRepository pokeBallRepository;

    @Mock
    private TrainerRepository trainerRepository;

    @Test
    public void master_ball_is_false() {
        // given
        given(trainerRepository.findById(anyString())).willReturn(new Trainer("test"));
        given(pokemonRepository.findByNumber(anyInt())).willReturn(new Pokemon(1, "피카츄", "", 1));
        given(pokeBallRepository.findById(1)).willReturn(Optional.of(new PokeBall(1, "마스터볼", 255)));

        // when
        final boolean caught = catchingService.tryCatching("test", 1, 1);

        // then
        assertThat(caught).isFalse();
    }
}