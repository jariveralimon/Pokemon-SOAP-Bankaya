package com.soap.pokemon.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();

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
            return "Error parsing abilities: " + e.getMessage();
        }
    }

    public static int parseBaseExperience(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("base_experience").asInt();
        } catch (IOException e) {
            System.err.println("Error parsing base_experience: " + e.getMessage());
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
            return "Error parsing held items: " + e.getMessage();
        }
    }

    public static int parseId(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("id").asInt();
        } catch (IOException e) {
            System.err.println("Error parsing id: " + e.getMessage());
            return 0;
        }
    }

    public static String parseName(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("forms").get(0).path("name").asText();
        } catch (IOException e) {
            return "Error parsing name: " + e.getMessage();
        }
    }

    public static String parseLocationAreaEncounters(String json) {
        try {
            JsonNode root = objectMapper.readTree(json);
            return root.path("location_area_encounters").asText();
        } catch (IOException e) {
            return "Error parsing location area encounters: " + e.getMessage();
        }
    }
}
