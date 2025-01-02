package com.soap.pokemon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonResponse {
    private int id;
    private String name;

    @JsonProperty("base_experience")
    private int baseExperience;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;

    private List<AbilityWrapper> abilities;
    private List<ItemWrapper> heldItems;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public List<AbilityWrapper> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilityWrapper> abilities) {
        this.abilities = abilities;
    }

    public List<ItemWrapper> getHeldItems() {
        return heldItems;
    }

    public void setHeldItems(List<ItemWrapper> heldItems) {
        this.heldItems = heldItems;
    }

    // Clases anidadas para AbilityWrapper e ItemWrapper
    public static class AbilityWrapper {
        private Ability ability;

        public AbilityWrapper() {
        }

        public AbilityWrapper(Ability ability) {
            this.ability = ability;
        }

        public Ability getAbility() {
            return ability;
        }

        public void setAbility(Ability ability) {
            this.ability = ability;
        }
    }

    public static class Ability {
        private String name;

        public Ability() {
        }

        public Ability(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ItemWrapper {
        private Item item;

        public ItemWrapper() {
        }

        public ItemWrapper(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    public static class Item {
        private String name;

        public Item() {
        }

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
