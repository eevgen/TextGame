package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Location {

    private String name;
    private String description;
    private Map<Direction, Location> exits;
    private List<Item> items;
    private List<NPC> characters;
    private boolean locked;
    private List<String> unlockItems;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.locked = false;
        this.unlockItems = new ArrayList<>();
    }

    public void addExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    public Location getExit(String direction) {
        try {
            Direction dir = Direction.fromString(direction);
            return exits.get(dir);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String id) {
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public void addCharacter(NPC character) {
        characters.add(character);
    }

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        this.locked = false;
    }

    public void showExits() {
        System.out.print("Východy: ");
        for (Direction direction : exits.keySet()) {
            System.out.print(direction.getId() + " ");
        }
        System.out.println();
    }

    public void showItems() {
        System.out.print("Items: ");
        for (Item item : items) {
            System.out.print(item.getId() + " ");
        }
        System.out.println();
    }

    public String getUnlockItemsIdsText() {

        StringBuilder resultString = new StringBuilder();

        for (String unlockItemId : unlockItems) {
            resultString.append(unlockItemId).append(" ");
        }
        return resultString.toString();
    }

}
