package com.soap.pokemon.service;

public interface PokemonService {
    String getAbilities(String pokemon);
    String getBaseExperience(String pokemon);
    String getHeldItems(String pokemon);
    String getId(String pokemon);
    String getName(String pokemon);
    String getLocationAreaEncounters(String pokemon);
}
