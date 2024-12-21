package com.soap.pokemon.endpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.soap.pokemon.service.PokemonService;

class SwaggerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PokemonService pokemonService;

    @InjectMocks
    private SwaggerController swaggerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(swaggerController).build();
    }

    @Test
    void getAbilities_shouldReturnAbilities() throws Exception {
        String pokemon = "pikachu";
        String abilities = "static, lightning-rod";
        when(pokemonService.getAbilities(pokemon)).thenReturn(abilities);

        mockMvc.perform(get("/ws/{pokemon}/abilities", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(abilities));

        verify(pokemonService, times(1)).getAbilities(pokemon);
    }

    @Test
    void getBaseExperience_shouldReturnBaseExperience() throws Exception {
        String pokemon = "pikachu";
        int baseExperience = 112;
        when(pokemonService.getBaseExperience(pokemon)).thenReturn(baseExperience);

        mockMvc.perform(get("/ws/{pokemon}/base-experience", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(baseExperience)));

        verify(pokemonService, times(1)).getBaseExperience(pokemon);
    }

    @Test
    void getHeldItems_shouldReturnHeldItems() throws Exception {
        String pokemon = "pikachu";
        String heldItems = "light-ball";
        when(pokemonService.getHeldItems(pokemon)).thenReturn(heldItems);

        mockMvc.perform(get("/ws/{pokemon}/held-items", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(heldItems));

        verify(pokemonService, times(1)).getHeldItems(pokemon);
    }

    @Test
    void getId_shouldReturnId() throws Exception {
        String pokemon = "pikachu";
        int id = 25;
        when(pokemonService.getId(pokemon)).thenReturn(id);

        mockMvc.perform(get("/ws/{pokemon}/id", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(id)));

        verify(pokemonService, times(1)).getId(pokemon);
    }

    @Test
    void getName_shouldReturnName() throws Exception {
        String pokemon = "pikachu";
        String name = "Pikachu";
        when(pokemonService.getName(pokemon)).thenReturn(name);

        mockMvc.perform(get("/ws/{pokemon}/name", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(name));

        verify(pokemonService, times(1)).getName(pokemon);
    }

    @Test
    void getLocationAreaEncounters_shouldReturnLocationAreaEncounters() throws Exception {
        String pokemon = "pikachu";
        String locationAreaEncounters = "forest, field";
        when(pokemonService.getLocationAreaEncounters(pokemon)).thenReturn(locationAreaEncounters);

        mockMvc.perform(get("/ws/{pokemon}/location-area-encounters", pokemon)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(locationAreaEncounters));

        verify(pokemonService, times(1)).getLocationAreaEncounters(pokemon);
    }
}
