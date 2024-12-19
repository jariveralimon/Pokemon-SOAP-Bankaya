package com.soap.pokemon.service.impl;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.soap.pokemon.model.LogEndpoint;
import com.soap.pokemon.repository.LogEndpointRepository;
import com.soap.pokemon.service.PokemonService;
import com.soap.pokemon.util.JsonParser;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class PokemonServiceImpl implements PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";

    private final RestTemplate restTemplate;

    private final LogEndpointRepository logRepository;

    private final HttpServletRequest httpRequest;

    public PokemonServiceImpl(RestTemplate restTemplate, LogEndpointRepository logRepository, HttpServletRequest httpRequest){
        this.restTemplate = restTemplate;
        this.logRepository = logRepository;
        this.httpRequest = httpRequest;
    }

    private void saveLog(String metodo, String requestParam, String responseValue, long duration, HttpServletRequest request) {
        LogEndpoint log = new LogEndpoint();
        String ip = "127.0.0.1";
        if (request != null) {
            ip = request.getRemoteAddr();
        }
        log.setIpDeOrigen(ip);
        log.setFechaRequest(LocalDateTime.now());
        log.setMetodo(metodo);
        log.setRequest(requestParam);
        log.setResponse(responseValue);
        log.setTiempoPeticion(duration);
        logRepository.save(log);
    }

    @Override
    public String getAbilities(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        String abilities = JsonParser.parseAbilities(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("abilities", pokemon, abilities, duration, httpRequest);
        return abilities;
    }

    @Override
    public int getBaseExperience(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        int baseExperience = JsonParser.parseBaseExperience(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("base_experience", pokemon, String.valueOf(baseExperience), duration, httpRequest);
        return baseExperience;
    }

    @Override
    public String getHeldItems(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        String heldItems = JsonParser.parseHeldItems(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("held_items", pokemon, heldItems, duration, httpRequest);
        return heldItems;
    }

    @Override
    public int getId(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        int id = JsonParser.parseId(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("id", pokemon, String.valueOf(id), duration, httpRequest);
        return id;
    }

    @Override
    public String getName(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        String name = JsonParser.parseName(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("name", pokemon, name, duration, httpRequest);
        return name;
    }

    @Override
    public String getLocationAreaEncounters(String pokemon) {
        long startTime = System.currentTimeMillis();
        ResponseEntity<String> response = restTemplate.getForEntity(POKEAPI_URL + pokemon, String.class);
        String locationAreaEncounters = JsonParser.parseLocationAreaEncounters(response.getBody());
        long duration = System.currentTimeMillis() - startTime;

        saveLog("location_area_encounters", pokemon, locationAreaEncounters, duration, httpRequest);
        return locationAreaEncounters;
    }
}
