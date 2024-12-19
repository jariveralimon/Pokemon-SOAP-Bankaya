package com.soap.pokemon.service;

public interface PokemonService {
    String getAbilities(String pokemon);
    int getBaseExperience(String pokemon);
    String getHeldItems(String pokemon);
    int getId(String pokemon);
    String getName(String pokemon);
    String getLocationAreaEncounters(String pokemon);
}
