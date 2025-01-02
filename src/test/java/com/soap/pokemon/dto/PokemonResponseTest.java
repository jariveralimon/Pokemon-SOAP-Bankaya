package com.soap.pokemon.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import java.util.List;

class PokemonResponseTest {

    @Test
    void testPokemonResponseGettersAndSetters() {
        // Crear instancia de PokemonResponse
        PokemonResponse response = new PokemonResponse();

        // Configurar valores
        response.setId(25);
        response.setName("pikachu");
        response.setBaseExperience(112);
        response.setLocationAreaEncounters("kanto-route-1");

        PokemonResponse.AbilityWrapper ability1 = new PokemonResponse.AbilityWrapper(new PokemonResponse.Ability("static"));
        PokemonResponse.AbilityWrapper ability2 = new PokemonResponse.AbilityWrapper(new PokemonResponse.Ability("lightning-rod"));
        response.setAbilities(List.of(ability1, ability2));

        PokemonResponse.ItemWrapper item1 = new PokemonResponse.ItemWrapper(new PokemonResponse.Item("oran-berry"));
        PokemonResponse.ItemWrapper item2 = new PokemonResponse.ItemWrapper(new PokemonResponse.Item("sitrus-berry"));
        response.setHeldItems(List.of(item1, item2));

        // Verificaciones
        assertEquals(25, response.getId());
        assertEquals("pikachu", response.getName());
        assertEquals(112, response.getBaseExperience());
        assertEquals("kanto-route-1", response.getLocationAreaEncounters());

        assertNotNull(response.getAbilities());
        assertEquals(2, response.getAbilities().size());
        assertEquals("static", response.getAbilities().get(0).getAbility().getName());
        assertEquals("lightning-rod", response.getAbilities().get(1).getAbility().getName());

        assertNotNull(response.getHeldItems());
        assertEquals(2, response.getHeldItems().size());
        assertEquals("oran-berry", response.getHeldItems().get(0).getItem().getName());
        assertEquals("sitrus-berry", response.getHeldItems().get(1).getItem().getName());
    }

    @Test
    void testAbilityWrapper() {
        // Crear instancia de AbilityWrapper
        PokemonResponse.Ability ability = new PokemonResponse.Ability("static");
        PokemonResponse.AbilityWrapper abilityWrapper = new PokemonResponse.AbilityWrapper(ability);

        // Verificaciones
        assertNotNull(abilityWrapper);
        assertNotNull(abilityWrapper.getAbility());
        assertEquals("static", abilityWrapper.getAbility().getName());

        // Cambiar valor
        abilityWrapper.setAbility(new PokemonResponse.Ability("lightning-rod"));
        assertEquals("lightning-rod", abilityWrapper.getAbility().getName());
    }

    @Test
    void testAbility() {
        // Crear instancia de Ability
        PokemonResponse.Ability ability = new PokemonResponse.Ability("static");

        // Verificaciones
        assertNotNull(ability);
        assertEquals("static", ability.getName());

        // Cambiar valor
        ability.setName("lightning-rod");
        assertEquals("lightning-rod", ability.getName());
    }

    @Test
    void testItemWrapper() {
        // Crear instancia de ItemWrapper
        PokemonResponse.Item item = new PokemonResponse.Item("oran-berry");
        PokemonResponse.ItemWrapper itemWrapper = new PokemonResponse.ItemWrapper(item);

        // Verificaciones
        assertNotNull(itemWrapper);
        assertNotNull(itemWrapper.getItem());
        assertEquals("oran-berry", itemWrapper.getItem().getName());

        // Cambiar valor
        itemWrapper.setItem(new PokemonResponse.Item("sitrus-berry"));
        assertEquals("sitrus-berry", itemWrapper.getItem().getName());
    }

    @Test
    void testItem() {
        // Crear instancia de Item
        PokemonResponse.Item item = new PokemonResponse.Item("oran-berry");

        // Verificaciones
        assertNotNull(item);
        assertEquals("oran-berry", item.getName());

        // Cambiar valor
        item.setName("sitrus-berry");
        assertEquals("sitrus-berry", item.getName());
    }

    @Test
    void testDefaultConstructors() {
        // Constructor por defecto para AbilityWrapper
        PokemonResponse.AbilityWrapper abilityWrapper = new PokemonResponse.AbilityWrapper();
        assertNotNull(abilityWrapper);

        // Constructor por defecto para Ability
        PokemonResponse.Ability ability = new PokemonResponse.Ability();
        assertNotNull(ability);

        // Constructor por defecto para ItemWrapper
        PokemonResponse.ItemWrapper itemWrapper = new PokemonResponse.ItemWrapper();
        assertNotNull(itemWrapper);

        // Constructor por defecto para Item
        PokemonResponse.Item item = new PokemonResponse.Item();
        assertNotNull(item);
    }
}
