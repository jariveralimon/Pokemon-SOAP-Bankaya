package com.soap.pokemon.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soap.pokemon.service.PokemonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("ws")
@Tag(name = "Pokemon SOAP", description = "Servicios para consultar información sobre Pokémon usando SOAP")
public class SwaggerController {

    private final PokemonService pokemonService;

    public SwaggerController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Operation(summary = "Obtener habilidades de un Pokémon")
    @GetMapping("/{pokemon}/abilities")
    public String getAbilities(@PathVariable String pokemon) {
        return pokemonService.getAbilities(pokemon);
    }

    @Operation(summary = "Obtener experiencia base de un Pokémon")
    @GetMapping("/{pokemon}/base-experience")
    public int getBaseExperience(@PathVariable String pokemon) {
        return pokemonService.getBaseExperience(pokemon);
    }

    @Operation(summary = "Obtener objetos sostenidos de un Pokémon")
    @GetMapping("/{pokemon}/held-items")
    public String getHeldItems(@PathVariable String pokemon) {
        return pokemonService.getHeldItems(pokemon);
    }

    @Operation(summary = "Obtener el ID de un Pokémon")
    @GetMapping("/{pokemon}/id")
    public int getId(@PathVariable String pokemon) {
        return pokemonService.getId(pokemon);
    }

    @Operation(summary = "Obtener el nombre de un Pokémon")
    @GetMapping("/{pokemon}/name")
    public String getName(@PathVariable String pokemon) {
        return pokemonService.getName(pokemon);
    }

    @Operation(summary = "Obtener encuentros de área de ubicación de un Pokémon")
    @GetMapping("/{pokemon}/location-area-encounters")
    public String getLocationAreaEncounters(@PathVariable String pokemon) {
        return pokemonService.getLocationAreaEncounters(pokemon);
    }
}
