package com.soap.pokemon.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    // Constructor privado para evitar instanciación de la clase
    private JsonParser() {
        throw new UnsupportedOperationException("Utility class should not be instantiated");
    }

    public static String parseAbilities(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode abilities = root.path("abilities");
            StringBuilder result = new StringBuilder();

            for (JsonNode abilityNode : abilities) {
                result.append(abilityNode.path("ability").path("name").asText()).append(", ");
            }

            return result.toString().replaceAll(", $", "");
        } catch (IOException e) {
            logger.error("Error parsing abilities: {}", e.getMessage(), e);
            return "Error parsing abilities: " + e.getMessage();
        }
    }

    public static int parseBaseExperience(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("base_experience").asInt();
        } catch (IOException e) {
            logger.error("Error parsing base_experience: {}", e.getMessage(), e);
            return 0;
        }
    }

    public static String parseHeldItems(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            JsonNode heldItems = root.path("held_items");
            StringBuilder result = new StringBuilder();

            for (JsonNode itemNode : heldItems) {
                result.append(itemNode.path("item").path("name").asText()).append(", ");
            }

            return result.toString().replaceAll(", $", "");
        } catch (IOException e) {
            logger.error("Error parsing held items: {}", e.getMessage(), e);
            return "Error parsing held items: " + e.getMessage();
        }
    }

    public static int parseId(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("id").asInt();
        } catch (IOException e) {
            logger.error("Error parsing id: {}", e.getMessage(), e);
            return 0;
        }
    }

    public static String parseName(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("forms").get(0).path("name").asText();
        } catch (IOException e) {
            logger.error("Error parsing name: {}", e.getMessage(), e);
            return "Error parsing name: " + e.getMessage();
        }
    }

    public static String parseLocationAreaEncounters(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("location_area_encounters").asText();
        } catch (IOException e) {
            logger.error("Error parsing location area encounters: {}", e.getMessage(), e);
            return "Error parsing location area encounters: " + e.getMessage();
        }
    }
}
