package com.soap.pokemon.service.impl;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.soap.pokemon.model.LogEndpoint;
import com.soap.pokemon.repository.LogEndpointRepository;
import com.soap.pokemon.util.JsonParser;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
class PokemonServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private LogEndpointRepository logRepository;

    @Mock
    private HttpServletRequest httpRequest;

    @InjectMocks
    private PokemonServiceImpl pokemonService;

    private final String pokemonName = "pikachu";
    private final String mockJsonResponse = "{\"abilities\":[{\"ability\":{\"name\":\"static\"}},{\"ability\":{\"name\":\"lightning-rod\"}}]}";
    private final String parsedAbilities = "static, lightning-rod";

    @SuppressWarnings("unchecked")
    @Test
    void testGetAbilities() {
        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponse);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseAbilities(any(String.class))).thenReturn(parsedAbilities);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("abilities");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(parsedAbilities);
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            String abilities = pokemonService.getAbilities(pokemonName);

            assertNotNull(abilities);
            assertEquals(parsedAbilities, abilities);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseAbilities(mockJsonResponse), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetAbilitiesWithNullHttpRequest() {
        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponse);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseAbilities(any(String.class))).thenReturn(parsedAbilities);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("abilities");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(parsedAbilities);
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            String abilities = pokemonService.getAbilities(pokemonName);

            // Assertions
            assertNotNull(abilities, "The abilities no debe de ser null");
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetBaseExperience() {
        String mockJsonResponseTestGetBaseExperience = "{\"base_experience\":112}";
        int expectedBaseExperience = 112;

        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponseTestGetBaseExperience);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseBaseExperience(any(String.class))).thenReturn(expectedBaseExperience);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("base_experience");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(String.valueOf(expectedBaseExperience));
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            int baseExperience = pokemonService.getBaseExperience(pokemonName);

            assertEquals(expectedBaseExperience, baseExperience);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseBaseExperience(mockJsonResponseTestGetBaseExperience), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetHeldItems() {
        String mockJsonResponseTestGetHeldItems = "{\"held_items\":[{\"item\":{\"name\":\"oran-berry\"}},{\"item\":{\"name\":\"sitrus-berry\"}}]}";
        String expectedHeldItems = "oran-berry, sitrus-berry";

        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponseTestGetHeldItems);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseHeldItems(any(String.class))).thenReturn(expectedHeldItems);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("held_items");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(expectedHeldItems);
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            String heldItems = pokemonService.getHeldItems(pokemonName);

            assertNotNull(heldItems);
            assertEquals(expectedHeldItems, heldItems);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseHeldItems(mockJsonResponseTestGetHeldItems), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetId() {
        String mockJsonResponseTestGetId = "{\"id\":25}";
        int expectedId = 25;

        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponseTestGetId);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseId(any(String.class))).thenReturn(expectedId);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("id");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(String.valueOf(expectedId));
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            int id = pokemonService.getId(pokemonName);

            assertEquals(expectedId, id);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseId(mockJsonResponseTestGetId), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetName() {
        String mockJsonResponseTestGetName = "{\"name\":\"pikachu\"}";
        String expectedName = "pikachu";

        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponseTestGetName);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseName(any(String.class))).thenReturn(expectedName);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("name");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(expectedName);
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            String name = pokemonService.getName(pokemonName);

            assertNotNull(name);
            assertEquals(expectedName, name);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseName(mockJsonResponseTestGetName), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    void testGetLocationAreaEncounters() {
        String mockJsonResponseTestGetLocationAreaEncounters = "{\"location_area_encounters\":\"kanto-route-2\"}";
        String expectedLocationAreaEncounters = "kanto-route-2";

        ResponseEntity<String> mockResponse = mock(ResponseEntity.class);
        when(restTemplate.getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class))
                .thenReturn(mockResponse);
        when(mockResponse.getBody()).thenReturn(mockJsonResponseTestGetLocationAreaEncounters);

        try (var mockStatic = mockStatic(JsonParser.class)) {
            mockStatic.when(() -> JsonParser.parseLocationAreaEncounters(any(String.class))).thenReturn(expectedLocationAreaEncounters);

            LogEndpoint simulatedLog = new LogEndpoint();
            simulatedLog.setId(1L);
            simulatedLog.setIpDeOrigen("127.0.0.1");
            simulatedLog.setFechaRequest(LocalDateTime.now());
            simulatedLog.setMetodo("location_area_encounters");
            simulatedLog.setRequest(pokemonName);
            simulatedLog.setResponse(expectedLocationAreaEncounters);
            simulatedLog.setTiempoPeticion(100L);

            when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

            String locationAreaEncounters = pokemonService.getLocationAreaEncounters(pokemonName);

            assertNotNull(locationAreaEncounters);
            assertEquals(expectedLocationAreaEncounters, locationAreaEncounters);
            verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, String.class);
            mockStatic.verify(() -> JsonParser.parseLocationAreaEncounters(mockJsonResponseTestGetLocationAreaEncounters), times(1));
            verify(logRepository, times(1)).save(any(LogEndpoint.class));
        }
    }
}
