package org.example.model;

public class Player extends Character {

    private int health;

    public Player(String name, Location currentLocation, Backpack backpack, int health) {
        super(name, currentLocation, backpack);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
