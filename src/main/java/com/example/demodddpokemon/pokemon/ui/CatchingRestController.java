package com.example.demodddpokemon.pokemon.ui;

import com.example.demodddpokemon.pokemon.application.CatchingResponse;
import com.example.demodddpokemon.pokemon.application.CatchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatchingRestController {

    private CatchingService catchingService;

    public CatchingRestController(CatchingService catchingService) {
        this.catchingService = catchingService;
    }

    @GetMapping(value = "/catch/{pokemonNumber}")
    public ResponseEntity<CatchingResponse> catchingPokemon(
        @RequestParam(value = "pokeBall") int pokeBallId,
        @RequestParam(value = "trainer") String trainerId,
        @PathVariable int pokemonNumber
    ) {

        return ResponseEntity.ok().body(new CatchingResponse(catchingService.tryCatching(trainerId, pokemonNumber, pokeBallId)));
    }
}
