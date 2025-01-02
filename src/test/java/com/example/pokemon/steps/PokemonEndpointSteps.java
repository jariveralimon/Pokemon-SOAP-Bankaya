package com.example.pokemon.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.pokemon.*;
import com.soap.pokemon.endpoint.PokemonEndpoint;
import com.soap.pokemon.service.PokemonService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;

public class PokemonEndpointSteps {

    private PokemonService pokemonService;
    private PokemonEndpoint pokemonEndpoint;

    private GetAbilitiesResponse abilitiesResponse;
    private GetBaseExperienceResponse baseExperienceResponse;
    private GetHeldItemsResponse heldItemsResponse;
    private GetIdResponse idResponse;
    private GetNameResponse nameResponse;
    private GetLocationAreaEncountersResponse locationAreaEncountersResponse;

    @Given("el servicio SOAP esta disponible")
    public void elServicioSOAPEstaDisponible() {
        pokemonService = Mockito.mock(PokemonService.class);
        pokemonEndpoint = new PokemonEndpoint(pokemonService);
    }

    @When("realizo una peticion SOAP para obtener habilidades del Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerHabilidadesDelPokemon(String pokemon) {
        Mockito.when(pokemonService.getAbilities(pokemon)).thenReturn("static, lightning-rod");
        var request = new GetAbilitiesRequest();
        request.setPokemon(pokemon);
        abilitiesResponse = pokemonEndpoint.getAbilities(request);
    }

    @Then("la respuesta debe contener las habilidades {string}")
    public void laRespuestaDebeContenerLasHabilidades(String expectedAbilities) {
        assertNotNull(abilitiesResponse);
        assertEquals(expectedAbilities, abilitiesResponse.getAbilities());
    }

    @When("realizo una peticion SOAP para obtener la experiencia base del Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerLaExperienciaBaseDelPokemon(String pokemon) {
        Mockito.when(pokemonService.getBaseExperience(pokemon)).thenReturn("112");
        var request = new GetBaseExperienceRequest();
        request.setPokemon(pokemon);
        baseExperienceResponse = pokemonEndpoint.getBaseExperience(request);
    }

    @Then("la respuesta debe contener la experiencia base {string}")
    public void laRespuestaDebeContenerLaExperienciaBase(String expectedBaseExperience) {
        assertNotNull(baseExperienceResponse);
        assertEquals(expectedBaseExperience, baseExperienceResponse.getBaseExperience());
    }

    @When("realizo una peticion SOAP para obtener los objetos que sostiene el Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerLosObjetosQueSostieneElPokemon(String pokemon) {
        Mockito.when(pokemonService.getHeldItems(pokemon)).thenReturn("oran-berry, sitrus-berry");
        var request = new GetHeldItemsRequest();
        request.setPokemon(pokemon);
        heldItemsResponse = pokemonEndpoint.getHeldItems(request);
    }

    @Then("la respuesta debe contener los objetos {string}")
    public void laRespuestaDebeContenerLosObjetos(String expectedHeldItems) {
        assertNotNull(heldItemsResponse);
        assertEquals(expectedHeldItems, heldItemsResponse.getHeldItems());
    }

    @When("realizo una peticion SOAP para obtener el ID del Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerElIDDelPokemon(String pokemon) {
        Mockito.when(pokemonService.getId(pokemon)).thenReturn("25");
        var request = new GetIdRequest();
        request.setPokemon(pokemon);
        idResponse = pokemonEndpoint.getId(request);
    }

    @Then("la respuesta debe contener el ID {string}")
    public void laRespuestaDebeContenerElID(String expectedId) {
        assertNotNull(idResponse);
        assertEquals(expectedId, idResponse.getId());
    }

    @When("realizo una peticion SOAP para obtener el nombre del Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerElNombreDelPokemon(String pokemon) {
        Mockito.when(pokemonService.getName(pokemon)).thenReturn("pikachu");
        var request = new GetNameRequest();
        request.setPokemon(pokemon);
        nameResponse = pokemonEndpoint.getName(request);
    }

    @Then("la respuesta debe contener el nombre {string}")
    public void laRespuestaDebeContenerElNombre(String expectedName) {
        assertNotNull(nameResponse);
        assertEquals(expectedName, nameResponse.getName());
    }

    @When("realizo una peticion SOAP para obtener las áreas de encuentro del Pokemon {string}")
    public void realizoUnaPeticionSOAPParaObtenerLasAreasDeEncuentroDelPokemon(String pokemon) {
        Mockito.when(pokemonService.getLocationAreaEncounters(pokemon)).thenReturn("forest, plains");
        var request = new GetLocationAreaEncountersRequest();
        request.setPokemon(pokemon);
        locationAreaEncountersResponse = pokemonEndpoint.getLocationAreaEncounters(request);
    }

    @Then("la respuesta debe contener las áreas de encuentro {string}")
    public void laRespuestaDebeContenerLasAreasDeEncuentro(String expectedEncounters) {
        assertNotNull(locationAreaEncountersResponse);
        assertEquals(expectedEncounters, locationAreaEncountersResponse.getLocationAreaEncounters());
    }
}
