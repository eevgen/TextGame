package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game world location - contains items, NPCs, and connections to other locations.
 * Can be locked (requires key to pass).
 * @author Text Game Team
 */
@Getter
@Setter
public class Location {

    private String name;
    private String description;
    private Map<Direction, Location> exits;
    private List<Item> items;
    private List<NPC> characters;
    private boolean locked;

    /**
     * Creates location with name and description.
     * @param name location name
     * @param description location description shown to player
     */
    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.locked = false;
    }

    /**
     * Adds exit to adjacent location.
     * @param direction direction of exit (north, south, etc)
     * @param location destination location
     */
    public void addExit(Direction direction, Location location) {
        exits.put(direction, location);
    }

    /**
     * Gets location in given direction.
     * @param direction direction as string (e.g., "north")
     * @return adjacent location or null if no exit
     */
    public Location getExit(String direction) {
        try {
            Direction dir = Direction.fromString(direction);
            return exits.get(dir);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * Adds item to location.
     * @param item the item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes item from location.
     * @param item the item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Finds item by id (case-insensitive).
     * @param id the item id
     * @return item or null if not found
     */
    public Item findItem(String id) {
        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Adds NPC to location.
     * @param character the NPC to add
     */
    public void addCharacter(NPC character) {
        characters.add(character);
    }

    /**
     * Finds NPC by name (case-insensitive).
     * @param name the NPC name
     * @return NPC or null if not found
     */
    public NPC findCharacter(String name) {
        for (NPC npc : characters) {
            if (npc.getName().equalsIgnoreCase(name)) {
                return npc;
            }
        }
        return null;
    }

    /**
     * Checks if location is locked.
     * @return true if locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * Locks the location.
     */
    public void lock() {
        this.locked = true;
    }

    /**
     * Unlocks the location.
     */
    public void unlock() {
        this.locked = false;
    }

    /**
     * Prints available exits to console.
     */
    public void showExits() {
        System.out.print("Východy: ");
        for (Direction direction : exits.keySet()) {
            System.out.print(direction.getId() + " ");
        }
        System.out.println();
    }

}
