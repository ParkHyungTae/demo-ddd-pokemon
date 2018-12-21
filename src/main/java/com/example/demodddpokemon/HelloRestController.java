package com.example.demodddpokemon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping(value = "/")
    public String hello() {
        return "hello";
    }
}
