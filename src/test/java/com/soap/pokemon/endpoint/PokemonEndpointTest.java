package com.soap.pokemon.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.pokemon.GetAbilitiesRequest;
import com.example.pokemon.GetAbilitiesResponse;
import com.example.pokemon.GetBaseExperienceRequest;
import com.example.pokemon.GetBaseExperienceResponse;
import com.example.pokemon.GetHeldItemsRequest;
import com.example.pokemon.GetHeldItemsResponse;
import com.example.pokemon.GetIdRequest;
import com.example.pokemon.GetIdResponse;
import com.example.pokemon.GetLocationAreaEncountersRequest;
import com.example.pokemon.GetLocationAreaEncountersResponse;
import com.example.pokemon.GetNameRequest;
import com.example.pokemon.GetNameResponse;
import com.soap.pokemon.service.PokemonService;

@ExtendWith(MockitoExtension.class)
class PokemonEndpointTest {

    @Mock
    private PokemonService pokemonService;

    @InjectMocks
    private PokemonEndpoint pokemonEndpoint;

    @Test
    void testGetAbilities() {
        // Arrange
        GetAbilitiesRequest request = new GetAbilitiesRequest();
        request.setPokemon("pikachu");
        String expectedAbilities = "static, lightning-rod";

        when(pokemonService.getAbilities("pikachu")).thenReturn(expectedAbilities);

        // Act
        GetAbilitiesResponse response = pokemonEndpoint.getAbilities(request);

        // Assert
        assertEquals(expectedAbilities, response.getAbilities());
    }

    @Test
    void testGetBaseExperience() {
        // Arrange
        GetBaseExperienceRequest request = new GetBaseExperienceRequest();
        request.setPokemon("pikachu");
        int expectedBaseExperience = 112;

        when(pokemonService.getBaseExperience("pikachu")).thenReturn(expectedBaseExperience);

        // Act
        GetBaseExperienceResponse response = pokemonEndpoint.getBaseExperience(request);

        // Assert
        assertEquals(expectedBaseExperience, response.getBaseExperience());
    }

    @Test
    void testGetHeldItems() {
        // Arrange
        GetHeldItemsRequest request = new GetHeldItemsRequest();
        request.setPokemon("pikachu");
        String expectedHeldItems = "oran-berry, sitrus-berry";

        when(pokemonService.getHeldItems("pikachu")).thenReturn(expectedHeldItems);

        // Act
        GetHeldItemsResponse response = pokemonEndpoint.getHeldItems(request);

        // Assert
        assertEquals(expectedHeldItems, response.getHeldItems());
    }

    @Test
    void testGetId() {
        // Arrange
        GetIdRequest request = new GetIdRequest();
        request.setPokemon("pikachu");
        int expectedId = 25;

        when(pokemonService.getId("pikachu")).thenReturn(expectedId);

        // Act
        GetIdResponse response = pokemonEndpoint.getId(request);

        // Assert
        assertEquals(expectedId, response.getId());
    }

    @Test
    void testGetName() {
        // Arrange
        GetNameRequest request = new GetNameRequest();
        request.setPokemon("pikachu");
        String expectedName = "pikachu";

        when(pokemonService.getName("pikachu")).thenReturn(expectedName);

        // Act
        GetNameResponse response = pokemonEndpoint.getName(request);

        // Assert
        assertEquals(expectedName, response.getName());
    }

    @Test
    void testGetLocationAreaEncounters() {
        // Arrange
        GetLocationAreaEncountersRequest request = new GetLocationAreaEncountersRequest();
        request.setPokemon("pikachu");
        String expectedLocationAreaEncounters = "kanto-route-2";

        when(pokemonService.getLocationAreaEncounters("pikachu")).thenReturn(expectedLocationAreaEncounters);

        // Act
        GetLocationAreaEncountersResponse response = pokemonEndpoint.getLocationAreaEncounters(request);

        // Assert
        assertEquals(expectedLocationAreaEncounters, response.getLocationAreaEncounters());
    }
}
