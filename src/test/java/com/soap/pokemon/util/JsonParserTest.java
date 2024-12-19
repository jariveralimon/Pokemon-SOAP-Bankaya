package com.soap.pokemon.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class JsonParserTest {

    @Test
    void testParseAbilities() {
        String json = "{\"abilities\":[{\"ability\":{\"name\":\"static\"}},{\"ability\":{\"name\":\"lightning-rod\"}}]}";
        String expected = "static, lightning-rod";

        String result = JsonParser.parseAbilities(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseBaseExperience() {
        String json = "{\"base_experience\":112}";
        int expected = 112;

        int result = JsonParser.parseBaseExperience(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseHeldItems() {
        String json = "{\"held_items\":[{\"item\":{\"name\":\"oran-berry\"}},{\"item\":{\"name\":\"sitrus-berry\"}}]}";
        String expected = "oran-berry, sitrus-berry";

        String result = JsonParser.parseHeldItems(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseId() {
        String json = "{\"id\":25}";
        int expected = 25;

        int result = JsonParser.parseId(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseName() {
        String json = "{\"forms\":[{\"name\":\"pikachu\"}]}";
        String expected = "pikachu";

        String result = JsonParser.parseName(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseLocationAreaEncounters() {
        String json = "{\"location_area_encounters\":\"kanto-route-2\"}";
        String expected = "kanto-route-2";

        String result = JsonParser.parseLocationAreaEncounters(json);

        assertEquals(expected, result);
    }

    @Test
    void testParseAbilitiesWithInvalidJson() {
        String invalidJson = "invalid-json";
        String expected = "Error parsing abilities: Unrecognized token 'invalid': was expecting";

        String result = JsonParser.parseAbilities(invalidJson);

        assertTrue(result.startsWith(expected));
    }

    @Test
    void testParseBaseExperienceWithInvalidJson() {
        String invalidJson = "invalid-json";
        int expected = 0;

        int result = JsonParser.parseBaseExperience(invalidJson);

        assertEquals(expected, result);
    }

    @Test
    void testParseHeldItemsWithInvalidJson() {
        String invalidJson = "invalid-json";
        String expected = "Error parsing held items: Unrecognized token 'invalid': was expecting";

        String result = JsonParser.parseHeldItems(invalidJson);

        assertTrue(result.startsWith(expected));
    }

    @Test
    void testParseIdWithInvalidJson() {
        String invalidJson = "invalid-json";
        int expected = 0;

        int result = JsonParser.parseId(invalidJson);

        assertEquals(expected, result);
    }

    @Test
    void testParseNameWithInvalidJson() {
        String invalidJson = "invalid-json";
        String expected = "Error parsing name: Unrecognized token 'invalid': was expecting";

        String result = JsonParser.parseName(invalidJson);

        assertTrue(result.startsWith(expected));
    }

    @Test
    void testParseLocationAreaEncountersWithInvalidJson() {
        String invalidJson = "invalid-json";
        String expected = "Error parsing location area encounters: Unrecognized token 'invalid': was expecting";

        String result = JsonParser.parseLocationAreaEncounters(invalidJson);

        assertTrue(result.startsWith(expected));
    }

    @Test
    void testJsonParserCannotBeInstantiated() {
        // Obtén el constructor privado de la clase JsonParser
        Constructor<JsonParser> constructor;
        try {
            constructor = JsonParser.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            // Verifica que intentar usar el constructor privado lanza UnsupportedOperationException
            InvocationTargetException exception = assertThrows(InvocationTargetException.class, constructor::newInstance);

            // Valida que la causa de la excepción sea UnsupportedOperationException
            assertTrue(exception.getCause() instanceof UnsupportedOperationException, 
                "Expected cause to be UnsupportedOperationException");
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Error al acceder al constructor privado", e);
        }
    }
}
