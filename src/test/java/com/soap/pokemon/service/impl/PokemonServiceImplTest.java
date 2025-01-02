package com.soap.pokemon.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.soap.pokemon.dto.PokemonResponse.AbilityWrapper;
import com.soap.pokemon.dto.PokemonResponse.ItemWrapper;
import com.soap.pokemon.dto.PokemonResponse;
import com.soap.pokemon.model.LogEndpoint;
import com.soap.pokemon.repository.LogEndpointRepository;

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

    @Test
    void testGetAbilities() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setAbilities(List.of(
                new AbilityWrapper(new PokemonResponse.Ability("static")),
                new AbilityWrapper(new PokemonResponse.Ability("lightning-rod"))
        ));

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("abilities");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("static, lightning-rod");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String abilities = pokemonService.getAbilities(pokemonName);

        assertNotNull(abilities);
        assertEquals("static, lightning-rod", abilities);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetBaseExperience() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setBaseExperience(112);

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("base_experience");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("112");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String baseExperience = pokemonService.getBaseExperience(pokemonName);

        assertNotNull(baseExperience);
        assertEquals("112", baseExperience);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetHeldItems() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setHeldItems(List.of(
                new ItemWrapper(new PokemonResponse.Item("oran-berry")),
                new ItemWrapper(new PokemonResponse.Item("sitrus-berry"))
        ));

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("held_items");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("oran-berry, sitrus-berry");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String heldItems = pokemonService.getHeldItems(pokemonName);

        assertNotNull(heldItems);
        assertEquals("oran-berry, sitrus-berry", heldItems);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetId() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setId(25);

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("id");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("25");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String id = pokemonService.getId(pokemonName);

        assertNotNull(id);
        assertEquals("25", id);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetName() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setName("pikachu");

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("name");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("pikachu");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String name = pokemonService.getName(pokemonName);

        assertNotNull(name);
        assertEquals("pikachu", name);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetAbilitiesWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String abilities = pokemonService.getAbilities(pokemonName);

        assertNotNull(abilities);
        assertEquals(expectedErrorMessage, abilities);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetBaseExperienceWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String baseExperience = pokemonService.getBaseExperience(pokemonName);

        assertNotNull(baseExperience);
        assertEquals(expectedErrorMessage, baseExperience);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetHeldItemsWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String heldItems = pokemonService.getHeldItems(pokemonName);

        assertNotNull(heldItems);
        assertEquals(expectedErrorMessage, heldItems);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetIdWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String id = pokemonService.getId(pokemonName);

        assertNotNull(id);
        assertEquals(expectedErrorMessage, id);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetNameWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String name = pokemonService.getName(pokemonName);

        assertNotNull(name);
        assertEquals(expectedErrorMessage, name);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetLocationAreaEncounters() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setLocationAreaEncounters("kanto-route-2");

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("location_area_encounters");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("kanto-route-2");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String locationAreaEncounters = pokemonService.getLocationAreaEncounters(pokemonName);

        assertNotNull(locationAreaEncounters);
        assertEquals("kanto-route-2", locationAreaEncounters);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetLocationAreaEncountersWithException() {
        String expectedErrorMessage = "Error: Simulated RestClientException";

        // Simular excepción al realizar la petición REST
        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenThrow(new RestClientException("Simulated RestClientException"));

        // Verificar el flujo en caso de excepción
        String locationAreaEncounters = pokemonService.getLocationAreaEncounters(pokemonName);

        assertNotNull(locationAreaEncounters);
        assertEquals(expectedErrorMessage, locationAreaEncounters);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetAbilitiesThrowsException() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setAbilities(null); // Simular que las habilidades son null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("abilities");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontraron habilidades para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String abilities = pokemonService.getAbilities(pokemonName);

        assertNotNull(abilities);
        assertEquals("Error: No se encontraron habilidades para el Pokémon proporcionado.", abilities);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetBaseExperienceThrowsException() {
        PokemonResponse mockResponse = null; // Simular que el objeto completo es null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("base_experience");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontro la experiencia para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String baseExperience = pokemonService.getBaseExperience(pokemonName);

        assertNotNull(baseExperience);
        assertEquals("Error: No se encontro la experiencia para el Pokémon proporcionado.", baseExperience);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetHeldItemsThrowsException() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setHeldItems(null); // Simular que los objetos sostenidos son null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("held_items");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontraron objetos sostenidos para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String heldItems = pokemonService.getHeldItems(pokemonName);

        assertNotNull(heldItems);
        assertEquals("Error: No se encontraron objetos sostenidos para el Pokémon proporcionado.", heldItems);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetIdThrowsException() {
        PokemonResponse mockResponse = null; // Simular que el objeto completo es null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("id");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontro el id para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String id = pokemonService.getId(pokemonName);

        assertNotNull(id);
        assertEquals("Error: No se encontro el id para el Pokémon proporcionado.", id);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetLocationAreaEncountersThrowsException() {
        PokemonResponse mockResponse = new PokemonResponse();
        mockResponse.setLocationAreaEncounters(null); // Simular que las áreas específicas son null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("location_area_encounters");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontro las áreas específicas para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String locationAreaEncounters = pokemonService.getLocationAreaEncounters(pokemonName);

        assertNotNull(locationAreaEncounters);
        assertEquals("Error: No se encontro las áreas específicas para el Pokémon proporcionado.", locationAreaEncounters);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }

    @Test
    void testGetNameThrowsException() {
        PokemonResponse mockResponse = null; // Simular que el objeto completo es null

        when(restTemplate.getForEntity(any(String.class), eq(PokemonResponse.class)))
                .thenReturn(ResponseEntity.ok(mockResponse));

        LogEndpoint simulatedLog = new LogEndpoint();
        simulatedLog.setId(1L);
        simulatedLog.setIpDeOrigen("127.0.0.1");
        simulatedLog.setFechaRequest(LocalDateTime.now());
        simulatedLog.setMetodo("name");
        simulatedLog.setRequest(pokemonName);
        simulatedLog.setResponse("Error: No se encontro el nombre para el Pokémon proporcionado.");
        simulatedLog.setTiempoPeticion(100L);

        when(logRepository.save(any(LogEndpoint.class))).thenReturn(simulatedLog);

        String name = pokemonService.getName(pokemonName);

        assertNotNull(name);
        assertEquals("Error: No se encontro el nombre para el Pokémon proporcionado.", name);
        verify(restTemplate, times(1)).getForEntity("https://pokeapi.co/api/v2/pokemon/" + pokemonName, PokemonResponse.class);
        verify(logRepository, times(1)).save(any(LogEndpoint.class));
    }
}
