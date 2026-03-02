package org.example.model;

/**
 * Base class for any character that can move and carry items.
 * @author Yevhen Kalenichenko
 */
public abstract class Character {

    private String name;
    private Location currentLocation;
    private Backpack backpack;

    /**
     * Creates character with starting location and backpack.
     * @param name character name
     * @param currentLocation starting location
     * @param backpack character's backpack
     */
    public Character(String name, Location currentLocation, Backpack backpack) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.backpack = backpack;
    }

    /**
     * Gets character name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets current location.
     * @return current location
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Moves character to new location.
     * @param currentLocation new location
     */
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Gets character's backpack.
     * @return backpack
     */
    public Backpack getBackpack() {
        return backpack;
    }
}
