package com.soap.pokemon.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/pokemon";

    private final PokemonService pokemonService;

    public PokemonEndpoint(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {
        String abilities = pokemonService.getAbilities(request.getPokemon());
        GetAbilitiesResponse result = new GetAbilitiesResponse();
        result.setAbilities(abilities);
        return result;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
        String baseExperience = pokemonService.getBaseExperience(request.getPokemon());
        GetBaseExperienceResponse result = new GetBaseExperienceResponse();
        result.setBaseExperience(baseExperience);
        return result;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {
        String heldItems = pokemonService.getHeldItems(request.getPokemon());
        GetHeldItemsResponse result = new GetHeldItemsResponse();
        result.setHeldItems(heldItems);
        return result;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {
        String id = pokemonService.getId(request.getPokemon());
        GetIdResponse result = new GetIdResponse();
        result.setId(id);
        return result;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getName(@RequestPayload GetNameRequest request) {
        String name = pokemonService.getName(request.getPokemon());
        GetNameResponse result = new GetNameResponse();
        result.setName(name);
        return result;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        String locationAreaEncounters = pokemonService.getLocationAreaEncounters(request.getPokemon());
        GetLocationAreaEncountersResponse result = new GetLocationAreaEncountersResponse();
        result.setLocationAreaEncounters(locationAreaEncounters);
        return result;
    }
}
