package org.example.model;

public abstract class Character {

    private String name;
    private Location currentLocation;
    private Backpack backpack;

    public Character(String name, Location currentLocation, Backpack backpack) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.backpack = backpack;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Backpack getBackpack() {
        return backpack;
    }
}
