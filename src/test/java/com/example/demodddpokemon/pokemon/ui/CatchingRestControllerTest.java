package com.example.demodddpokemon.pokemon.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CatchingRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void master_ball() throws Exception {
        this.mockMvc.perform(
            get("/catch/150")
            .param("pokeBall", "1")
            .param("trainer", "test")
        ).andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("caught").value(true));
    }
}