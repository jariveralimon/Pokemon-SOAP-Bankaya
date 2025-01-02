package com.soap.pokemon.service.impl;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.soap.pokemon.dto.PokemonResponse;
import com.soap.pokemon.model.LogEndpoint;
import com.soap.pokemon.repository.LogEndpointRepository;
import com.soap.pokemon.service.PokemonService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class PokemonServiceImpl implements PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";
    private static final String ERROR_PREFIX = "Error: ";

    private final RestTemplate restTemplate;
    private final LogEndpointRepository logRepository;
    private final HttpServletRequest httpRequest;

    public PokemonServiceImpl(RestTemplate restTemplate, LogEndpointRepository logRepository, HttpServletRequest httpRequest) {
        this.restTemplate = restTemplate;
        this.logRepository = logRepository;
        this.httpRequest = httpRequest;
    }

    private void saveLog(String metodo, String requestParam, String responseValue, long duration, HttpServletRequest request) {
        LogEndpoint log = new LogEndpoint();
        String ip = request != null ? request.getRemoteAddr() : "127.0.0.1";
        log.setIpDeOrigen(ip);
        log.setFechaRequest(LocalDateTime.now());
        log.setMetodo(metodo);
        log.setRequest(requestParam);
        log.setResponse(responseValue);
        log.setTiempoPeticion(duration);
        logRepository.save(log);
    }

    private PokemonResponse fetchPokemonData(String pokemon) {
        ResponseEntity<PokemonResponse> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, PokemonResponse.class);
        return response.getBody();
    }

    @Override
    public String getAbilities(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null || data.getAbilities() == null) {
                throw new RestClientException("No se encontraron habilidades para el Pokémon proporcionado.");
            }
            String abilities = data.getAbilities().stream()
                    .map(abilityWrapper -> abilityWrapper.getAbility().getName())
                    .collect(Collectors.joining(", "));
            long duration = System.currentTimeMillis() - startTime;
            saveLog("abilities", pokemon, abilities, duration, httpRequest);
            return abilities;
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("abilities", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }

    @Override
    public String getBaseExperience(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null) {
                throw new RestClientException("No se encontro la experiencia para el Pokémon proporcionado.");
            }
            int baseExperience = data.getBaseExperience();
            long duration = System.currentTimeMillis() - startTime;
            saveLog("base_experience", pokemon, String.valueOf(baseExperience), duration, httpRequest);
            return String.valueOf(baseExperience);
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("base_experience", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }

    @Override
    public String getHeldItems(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null || data.getHeldItems() == null) {
                throw new RestClientException("No se encontraron objetos sostenidos para el Pokémon proporcionado.");
            }
            String heldItems = data.getHeldItems().stream()
                    .map(itemWrapper -> itemWrapper.getItem().getName())
                    .collect(Collectors.joining(", "));
            long duration = System.currentTimeMillis() - startTime;
            saveLog("held_items", pokemon, heldItems, duration, httpRequest);
            return heldItems;
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("held_items", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }

    @Override
    public String getId(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null) {
                throw new RestClientException("No se encontro el id para el Pokémon proporcionado.");
            }
            int id = data.getId();
            long duration = System.currentTimeMillis() - startTime;
            saveLog("id", pokemon, String.valueOf(id), duration, httpRequest);
            return String.valueOf(id);
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("id", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }

    @Override
    public String getName(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null) {
                throw new RestClientException("No se encontro el nombre para el Pokémon proporcionado.");
            }
            String name = data.getName();
            long duration = System.currentTimeMillis() - startTime;
            saveLog("name", pokemon, name, duration, httpRequest);
            return name;
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("name", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }

    @Override
    public String getLocationAreaEncounters(String pokemon) {
        long startTime = System.currentTimeMillis();
        try {
            PokemonResponse data = fetchPokemonData(pokemon);
            if (data == null || data.getLocationAreaEncounters() == null) {
                throw new RestClientException("No se encontro las áreas específicas para el Pokémon proporcionado.");
            }
            String locationAreaEncounters = data.getLocationAreaEncounters();
            long duration = System.currentTimeMillis() - startTime;
            saveLog("location_area_encounters", pokemon, locationAreaEncounters, duration, httpRequest);
            return locationAreaEncounters;
        } catch (RestClientException e) {
            long duration = System.currentTimeMillis() - startTime;
            String errorMessage = ERROR_PREFIX + e.getMessage();
            saveLog("location_area_encounters", pokemon, errorMessage, duration, httpRequest);
            return errorMessage;
        }
    }
}
